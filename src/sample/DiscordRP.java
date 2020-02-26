package sample;


import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;

public class DiscordRP {

    public static void init(){
        DiscordEventHandlers handlers = new DiscordEventHandlers();
        handlers.ready = (user) -> System.out.println("Ready!");
        DiscordRPC.discordInitialize("658359764664844316", handlers,true);
    }

    public static void twoPlayer(){
        DiscordRichPresence presence = new DiscordRichPresence.Builder("Versing a friend").setBigImage("logo", "Noughts and Crosses").build();
        presence.startTimestamp = System.currentTimeMillis() / 1000;
        DiscordRPC.discordUpdatePresence(presence);
    }

    public static void title(){
        DiscordRichPresence presence = new DiscordRichPresence.Builder("In the title screen").setBigImage("logo", "Noughts and Crosses").build();
        presence.startTimestamp = System.currentTimeMillis() / 1000;
        DiscordRPC.discordUpdatePresence(presence);
    }

    public static void onePlayer(){
        DiscordRichPresence presence = new DiscordRichPresence.Builder("Versing the computer").setBigImage("logo", "Noughts and Crosses").build();
        presence.startTimestamp = System.currentTimeMillis() / 1000;
        DiscordRPC.discordUpdatePresence(presence);
    }

    public static void close(){
        DiscordRPC.discordShutdown();
    }


}
