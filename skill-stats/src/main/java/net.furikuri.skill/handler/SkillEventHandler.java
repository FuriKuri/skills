package net.furikuri.skill.handler;


import net.furikuri.skill.event.SkillAddedEvent;
import net.furikuri.skill.event.SkillDeletedEvent;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventhandling.replay.ReplayAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class SkillEventHandler implements ReplayAware {
  private static final Logger LOG = LoggerFactory.getLogger(SkillEventHandler.class);

  @Autowired
  private RedisTemplate<String, String> redisClient;

  @EventHandler
  public void handle(SkillAddedEvent event) {
    LOG.info("Got event SkillAddedEvent");
    redisClient.opsForValue().increment(event.getSkill(), 1);
  }

  @EventHandler
  public void handle(SkillDeletedEvent event) {
    LOG.info("Got event SkillDeletedEvent");
    redisClient.opsForValue().increment(event.getSkill(), -1);
  }

  @Override
  public void beforeReplay() {
    LOG.info("Event Replay is about to START. Clearing the View...");
  }

  @Override
  public void afterReplay() {
    LOG.info("Event Replay has FINISHED.");
  }

  @Override
  public void onReplayFailed(Throwable cause) {
    LOG.error("Event Replay has FAILED.");
  }
}
