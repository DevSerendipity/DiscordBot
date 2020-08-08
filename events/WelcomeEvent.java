package DiscordBot.events;

import bot.Bot;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class WelcomeEvent extends ListenerAdapter {
    
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        
        String[] messageSent = event.getMessage().getContentRaw().split(" ");
        
        if (messageSent[0].equalsIgnoreCase( Bot.prefix + "welcome") && messageSent.length == 1) {
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("Welcome from me to!! :smile: ").queue();
        } else if(messageSent[0].equalsIgnoreCase(Bot.prefix + "welcome") && !(messageSent[1].isEmpty()) && messageSent.length == 2){
            event.getChannel().sendMessage("Heyy Welcome! It's nice to have you here " + event.getMessage().getMentionedMembers().get(0).getAsMention()).queue();
        }
    }
}
