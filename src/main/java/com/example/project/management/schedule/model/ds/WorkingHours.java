package com.example.project.management.schedule.model.ds;

import jakarta.persistence.Embeddable;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Embeddable
public class WorkingHours {
    private DayOfWeek dayOfWeek;
    private LocalDate day;
    private LocalTime startTime;
    private LocalTime endTime;
    //private List<WorkingHours> availability;

    public WorkingHours() {
    }
    public WorkingHours(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {

        this.dayOfWeek=dayOfWeek;
        this.startTime=startTime;
        this.endTime=endTime;
    }

    public WorkingHours(LocalDate day, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek=day.getDayOfWeek();
        this.day=day;
        this.startTime=startTime;
        this.endTime=endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime=startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime=endTime;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek=dayOfWeek;
    }

    public void setDay(LocalDate day) {
        this.day=day;
    }

    public LocalDate getDay() {
        return day;
    }


}
