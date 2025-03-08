package mystuff;

import java.net.InetAddress;

public class Exping {

    static class Ping implements Runnable {
        private String addr;

        Ping(String addr) {
            this.addr = addr;
        }

        public void run() {
            String output = "The address is " + (ping(addr) ? "" : "not ") + "reachable";
            System.out.println(output);
        }
    }

    private static void validateArgs(String[] args) {
        if (args.length < 2) {
            System.out.println(String.format(
                    "Usage: ./%s <ip/url 1> [ip/url 2] ...", args[0]));
            System.exit(0);
        }
    }

    private static boolean ping(String addr) {
        try {
            InetAddress address = InetAddress.getByName(addr);
            boolean status = address.isReachable(10000);

            return status;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * The main method.
     * 
     * @param args System arguments
     */
    public static void main(String[] args) {
        validateArgs(args);

        for (int i = 1; i < args.length; i++) {
            Thread thread = new Thread(new Ping(args[i]));
            thread.start();
        }
    }
}
