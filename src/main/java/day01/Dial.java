package day01;

public class Dial {

    private static final int DIAL_SIZE = 100;

    private int position;

    public Dial(int initialPosition) {
        this.position = initialPosition;
    }

    public void rotate(Rotation rotation) {
        position = Math.floorMod(
                position + rotation.sign() * rotation.distance(),
                DIAL_SIZE
        );
    }

    public int rotateAndCountZeroHits(Rotation rotation) {
        int zeroHits = countZeroHits(rotation);
        rotate(rotation);
        return zeroHits;
    }

    public boolean pointsToZero() {
        return position == 0;
    }

    private int countZeroHits(Rotation rotation) {
        int firstZeroHit;

        if (rotation.direction() == 'R') {
            firstZeroHit = Math.floorMod(DIAL_SIZE - position, DIAL_SIZE);
        } else {
            firstZeroHit = position;
        }

        if (firstZeroHit == 0) {
            firstZeroHit = DIAL_SIZE;
        }

        if (rotation.distance() < firstZeroHit) {
            return 0;
        }

        return 1 + (rotation.distance() - firstZeroHit) / DIAL_SIZE;
    }
}