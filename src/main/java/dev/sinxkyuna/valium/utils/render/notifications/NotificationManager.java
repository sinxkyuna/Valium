package dev.sinxkyuna.valium.utils.render.notifications;

import dev.sinxkyuna.valium.Client;
import dev.sinxkyuna.valium.event.bus.Listener;
import dev.sinxkyuna.valium.event.bus.annotations.EventLink;
import dev.sinxkyuna.valium.event.impl.player.EventTickPre;
import dev.sinxkyuna.valium.event.impl.render.EventRender2D;
import dev.sinxkyuna.valium.module.modules.client.Notifications;
import dev.sinxkyuna.valium.utils.Utils;
import dev.sinxkyuna.valium.utils.render.notifications.impl.Notification;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class NotificationManager implements Utils {

    private final List<Notification> notifications = new CopyOnWriteArrayList<>();

    @EventLink
    public final Listener<EventTickPre> eventTickPreListener = event -> {
        notifications.removeIf(Notification::shouldDisappear);
    };

    @EventLink
    public final Listener<EventRender2D> eventRender2DListener = event -> {
        if (mc.player == null || mc.world == null) {
            return;
        }
        if (!Client.INSTANCE.getModuleManager().getModule(Notifications.class).isEnabled()) {
            return;
        }
        int yOffset = 0;
        for (Notification notification : notifications) {
            notification.render(event, yOffset);
            yOffset += 17;
        }
    };

    public void addNewNotification(Notification notification) {
        notifications.add(notification);
    }
}
