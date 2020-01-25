public class Song {
    String title;
    int duration;

    public Song(String title, int duration) {
        this.title = title.toLowerCase();
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void printSong() {
        System.out.println(toTitleCase(title) + " - " + formatDuration(duration));
    }

    private static String formatDuration(int duration) {
        int days = 60 * 60 * 24;
        int hours = 60 * 60;
        int d = duration / days;
        int h = (duration - (d * days)) / hours;
        int m = (duration - (d * days) - (h * hours)) / 60;
        int s = duration % 60;

        String resultString = d > 0 ? d + "d " : "";
        resultString += h == 0 ? (resultString.isBlank() ? "" : h + "h ") : h + "h ";
        resultString += m == 0 ? (resultString.isBlank() ? "" : m + "m ") : m + "m ";
        resultString += s + "s";
        return resultString;
    }

    private String toTitleCase(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        StringBuilder converted = new StringBuilder();

        boolean convertNext = true;
        for (char ch : text.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                convertNext = true;
            } else if (convertNext) {
                ch = Character.toTitleCase(ch);
                convertNext = false;
            }
            converted.append(ch);
        }

        return converted.toString();
    }
}
