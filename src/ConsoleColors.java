public class ConsoleColors {
        // Reset
        private final String RESET = "\033[0m";  // Text Reset

        // Regular Colors
        public void RED(String error_text){
            System.out.println("\033[0;31m" + error_text);
            System.out.println(this.RESET);
        }
        public void YELLOW(String warning_text){
            System.out.println("\033[0;33m" + warning_text);
            System.out.println(this.RESET);
        }

        // Bold
        public void GREEN_BOLD(String success_text){
            System.out.println("\033[1;32m" + success_text);
            System.out.println(this.RESET);
        }


        // Underline
        public void RED_UNDERLINED(String s){
            System.out.println("\033[4;31m" + s);
            System.out.println(this.RESET);
        }

}
