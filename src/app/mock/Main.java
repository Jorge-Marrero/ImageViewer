package app.mock;

import control.Command;
import control.ExitCommand;
import control.LoadCommand;
import control.NextImageCommand;
import control.NullCommand;
import control.PrevImageCommand;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import model.Image;
import view.ImageDisplay;
import view.ImageLoader;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Command> commands = initCommands(createImageDisplay());
        commands.get("l").execute();
        while(true){
            commands.getOrDefault(scanner.next(), new NullCommand()).execute();
        }
        
    }   

    private static Map<String, Command> initCommands(ImageDisplay imageDisplay) {
        ArrayList<Image> imageList = new ArrayList<Image>();
        ImageLoader imageLoader = new MockImageLoader();
        Map<String, Command> commands = new HashMap<>();
        commands.put("l", new LoadCommand(imageLoader, imageList, imageDisplay));
        commands.put("q", new ExitCommand());
        commands.put("n", new NextImageCommand(imageList, imageDisplay));
        commands.put("p", new PrevImageCommand(imageList, imageDisplay));
        return commands;
    }

    private static ImageDisplay createImageDisplay() {
        ImageDisplay imageDisplay = new MockImageDisplay();
        return imageDisplay;
    }
}
