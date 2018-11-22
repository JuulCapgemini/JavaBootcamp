package capgemini.academy.bootcamp.time;

public abstract class CalenderText {
    protected static String CapitalStart(String text)
    {
        text = text.toLowerCase();
        StringBuilder sbText = new StringBuilder(text);
        sbText.deleteCharAt(0);
        char firstLetter = text.charAt(0);
        firstLetter = Character.toUpperCase(firstLetter);
        sbText.insert(0,firstLetter);
        return sbText.toString();
    }
}
