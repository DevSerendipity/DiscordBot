package DiscordBot.JDAPractice.jda.filter;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import org.jetbrains.annotations.NotNull;


public class Filter extends ListenerAdapter {

    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent e) {
        if (FilterOnOff.filterOn) {
            String[] LIST_OF_BAD_WORDS = {"***PROVIDE STRING BAD WORDS YOU WON T ALLOW TO THE SERVER***"};
            String[] message = e.getMessage().getContentRaw().split(" ");
            for (String s : message) {
                boolean badWord = false;
                //Check each message for each bad word
                for (String list_of_bad_word : LIST_OF_BAD_WORDS) {
                    if (s.equalsIgnoreCase(list_of_bad_word)) {
                        e.getMessage().delete().queue();
                        badWord = true;
                        if (FilterMessage.allowed) { //Prints a message saying watch your language IF enabled by !filtermessage
                            e.getChannel().sendMessage("Watching your mouth, swearing will not help " + e.getMember().getUser().getName() + " **Alright I am watching you** ").queue();
                        }
                    }
                }
                System.out.println(s + " " + badWord); //Reports everything to the console
            }
        }
    }
}
