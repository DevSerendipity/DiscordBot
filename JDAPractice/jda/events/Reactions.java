package DiscordBot.JDAPractice.jda.events;

import DiscordBot.JDAPractice.jda.BotCenter;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class Reactions extends ListenerAdapter {

    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {

        String[] messageSent = event.getMessage().getContentRaw().split(" ");

        if (messageSent[0].equalsIgnoreCase(BotCenter.prefix + "react")) {
            List<String> islam = event.getGuild().getEmotes().stream().map(e -> e.getName() + ":" + e.getId()).collect(Collectors.toList());
            event.getMessage().addReaction(islam.get(generateRandom(islam.size()))).queue();
            event.getMessage().addReaction(islam.get(generateRandom(islam.size()))).queue();
        } else if (messageSent[0].equalsIgnoreCase(BotCenter.prefix + "reactions")) {
            List<String> islam = event.getGuild().getEmotes().stream().map(e -> e.getName() + ":" + e.getId()).collect(Collectors.toList());
            for (String s : islam) {
                event.getMessage().addReaction(s).queue();
            }
        }
    }

    private int generateRandom(int length) {
        Random random = new Random();
        return random.nextInt(length);
    }
}

