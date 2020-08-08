package DiscordBot.JDAPractice.jda.command;

import bot.Bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class UserInfo extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        String[] message = e.getMessage().getContentRaw().split(" ");
        if (message.length == 1 && message[0].equalsIgnoreCase(Bot.prefix + "user")) {
            e.getChannel().sendMessage("To get the user's info, type !user [name]").queue();
        } else if (message.length == 2 && message[0].equalsIgnoreCase(Bot.prefix + "user")) {
            String userName = message[1];
            User user = e.getGuild().getMembersByName(userName, true).get(0).getUser();

            String avatar = user.getAvatarUrl();
            EmbedBuilder avatarEmbed = new EmbedBuilder();
            avatarEmbed.setTitle(userName + " 's info: ");
            avatarEmbed.setColor(Color.getHSBColor(229, 228, 226));
            avatarEmbed.addField("Name", user.getName(), true);
            avatarEmbed.addField("Online status: ", e.getGuild().getMembersByName(userName, true).get(0).getOnlineStatus().toString(), true);
            avatarEmbed.addField("Avatar: ", "The avatar is below," + e.getMember().getAsMention(), true);
            avatarEmbed.addField("Joined: ", "The date: " + e.getMember().getTimeJoined().format(DateTimeFormatter.ofPattern("dd-MM-YYYY")), false);
            avatarEmbed.setImage(avatar);
            avatarEmbed.setFooter("Request was made @ " + formatter.format(date), e.getGuild().getIconUrl());

            e.getChannel().sendMessage(avatarEmbed.build()).queue();
        }
    }
}

