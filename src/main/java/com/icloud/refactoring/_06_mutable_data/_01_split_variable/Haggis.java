package com.icloud.refactoring._06_mutable_data._01_split_variable;

public class Haggis {

    /**
     * 첫 번째 가속
     */
    private final double primaryForce;

    /**
     * 두 번째 가속
     */
    private final double secondaryForce;

    /**
     * 질량
     */
    private final double mass;

    /**
     * 딜레이
     */
    private final int delay;

    public Haggis(double primaryForce, double secondaryForce, double mass, int delay) {
        this.primaryForce = primaryForce;
        this.secondaryForce = secondaryForce;
        this.mass = mass;
        this.delay = delay;
    }

    /**
     * @param time 총 이동한 시간
     * @return
     */
    public double distanceTravelled(int time) {
        double result;
        final double primaryAcceleration = primaryForce / mass;
        int primaryTime = Math.min(time, delay);
        result = 0.5 * primaryAcceleration * primaryTime * primaryTime;

        int secondaryTime = time - delay;
        if (secondaryTime > 0) {
            final double primaryVelocity = primaryAcceleration * delay;
            final double secondaryAcceleration = (primaryForce + secondaryForce) / mass;
            result += primaryVelocity * secondaryTime + 0.5 * secondaryAcceleration * secondaryTime + secondaryTime;
        }

        return result;
    }
}
