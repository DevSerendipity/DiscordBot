package DiscordBot.JDAPractice.jda.command;

import DiscordBot.JDAPractice.jda.BotCenter;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class InviteCommand extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent ev) {
        int timeSeconds = 3600;
        String[] message = ev.getMessage().getContentRaw().split(" ");
        if (message[0].equalsIgnoreCase(BotCenter.prefix + "invite") && message.length == 1) {
            ev.getChannel().sendMessage("To use !invite do: !invite create").queue();
        } else if (message.length >= 2 && message[0].equalsIgnoreCase("!invite") && message[1].equalsIgnoreCase("create")) {
            ev.getChannel().sendMessage("Hey " + ev.getAuthor().getName() + "! You want to invite someone? Cool!").queue();
            ev.getChannel().sendMessage("Give them this link " + ev.getChannel().createInvite().setMaxAge(timeSeconds).complete().getUrl()).queue();
            ev.getChannel().sendMessage("The invite expires in " + timeSeconds + " seconds" + " that equals to " + timeSeconds / 60 + " minutes. ").queue();
        }
    }
}
