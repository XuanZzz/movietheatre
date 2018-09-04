import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

public class Client {
    private MovieTheatre movieTheatre;
    private String inpath;
    private String outpath;

    public Client(String inpath, String outpath) {
        this.inpath = inpath;
        this.outpath = outpath;
    }

    private List<Reservation> getRequests() throws Exception {
        List<Reservation> requests = new ArrayList<Reservation>();

        File infile = new File(inpath);
        if(!infile.exists() || infile.isDirectory()) {
            System.out.println("Not Found");
            return requests;
        }

        // read file and add new requests to list
        Scanner scanner = new Scanner(infile);
        while (scanner.hasNextLine()) {
            String[] orderInfo = scanner.nextLine().split(" ");
            if(orderInfo.length != 2) {
                throw new IllegalArgumentException("Invalid input format! R#### + Number of seats!");
            }
            Reservation request = new Reservation(orderInfo[0], Integer.parseInt(orderInfo[1]));
            requests.add(request);
        }

        return requests;
    }

    private void handleSingleRequest(FileOutputStream outStream, Reservation request) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(request.getId());
        stringBuilder.append(' ');
        try {
            // try to get requested seats
            List<MovieTheatreSeat> seats = movieTheatre.getSeats(request.getNumSeats());
            // first append reservation identifier
            // then append seat indexes
            for (MovieTheatreSeat seat : seats) {
                stringBuilder.append(seat.getName());
                stringBuilder.append(',');
            }
            stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "\n");
        }
        // log exception msg to output file if not successful
        catch (Exception e) {
            stringBuilder.append(e.getMessage());
            stringBuilder.append('\n');
        }
        outStream.write(stringBuilder.toString().getBytes());
    }

    private void handleRequests(List<Reservation> requests) throws Exception {
        FileOutputStream outStream = new FileOutputStream(outpath, false);

        // handle each request
        for(Reservation request : requests) {
            handleSingleRequest(outStream, request);
        }

        outStream.flush();
        outStream.close();
    }

    public void run() throws Exception {
        List<Reservation> requests = getRequests();
        movieTheatre = new MovieTheatre(10, 20);
        handleRequests(requests);
        System.out.println(outpath);
    }

    /* Command line handling here. */
    private static Namespace parseArgs(String[] args) {
        ArgumentParser parser = ArgumentParsers.newFor("Client").build()
                .description("Client for Movie Theatre");
        parser.addArgument("input_file").type(String.class)
                .help("Full path to input file");

        Namespace res = null;
        try {
            res = parser.parseArgs(args);
        } catch (ArgumentParserException e){
            parser.handleError(e);
        }
        return res;
    }

    private static String getOutputFilename(String filename) {
        int suffix = filename.lastIndexOf('.');
        String prefix = filename.substring(0, suffix);
        return prefix + "-output.txt";
    }

    public static void main(String[] args) throws Exception {
        Namespace c_args = parseArgs(args);
        if (c_args == null){
            throw new RuntimeException("Argument parsing failed");
        }

        String filepath = c_args.getString("input_file");
        String outpath = getOutputFilename(filepath);
        Client client = new Client(filepath, outpath);
        client.run();
    }
}
