package com.github.fadeciness.lesson7.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Race {

    private final Integer participantsCount;
    private final CyclicBarrier cyclicBarrier;
    private final CountDownLatch participantsPrepared;
    private final CountDownLatch participantsFinish;
    private final ArrayList<Stage> stages;
    public Integer getParticipantsCount() {
        return participantsCount;
    }

    public CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }

    public CountDownLatch getParticipantsPrepared() {
        return participantsPrepared;
    }

    public CountDownLatch getParticipantsFinish() {
        return participantsFinish;
    }


    public ArrayList<Stage> getStages() { return stages; }
    public Race(Integer participantsCount, Stage... stages) {
        int lastStageCount = 0;
        for (Stage stage : stages) {
            if (stage.getIsLast()) {
                lastStageCount++;
            }
        }
        if (lastStageCount != 1) {
            throw new IllegalArgumentException("Race must contain 1 stage marked as 'isLast'");
        }
        this.participantsCount = participantsCount;
        this.cyclicBarrier = new CyclicBarrier(this.participantsCount);
        this.participantsPrepared = new CountDownLatch(this.participantsCount);
        this.participantsFinish = new CountDownLatch(this.participantsCount);
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}
