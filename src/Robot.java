public class Robot {

    private static int MAX_POSITION = 4;
    private static int MIN_POSITION = 0;

    public int xPosition;
    public int yPosition;
    public Direction facingDirection;
    boolean placeCommandHasBeenIssued;

    public Robot() {
        xPosition = 0;
        yPosition = 0;
        facingDirection = Direction.NORTH;
        placeCommandHasBeenIssued = false;
    }

    /**
     * 
     * @param xPos xPosition
     * @param yPos yPosition
     * @param fDirection facing direction
     * 
     * This method places the robot in x, y coordinates in the specific direction 
     */
    public void place(int xPos, int yPos, String fDirection) {

        boolean checkValidDirection = false;
        for (Direction direction : Direction.values()) {
            if (direction.name().equalsIgnoreCase(fDirection)) {
                checkValidDirection = true;
            }
        }

        if ((xPos >= MIN_POSITION && xPos <= MAX_POSITION)
                && (yPos >= MIN_POSITION && yPos <= MAX_POSITION)
                && checkValidDirection) {
            xPosition = xPos;
            yPosition = yPos;
            facingDirection = Direction.valueOf(fDirection);
            placeCommandHasBeenIssued = true;
        }
    }

    public void move() {

        if (placeCommandHasBeenIssued) {
            switch (facingDirection) {

                case NORTH:
                    if (isValidForwardPosition(yPosition + 1)) {
                            yPosition++;
                    }
                    break;

                case SOUTH:
                    if (isValidBackwardPosition(yPosition - 1)) {
                        yPosition--;
                    }
                    break;

                case EAST:
                    if (isValidForwardPosition(xPosition + 1)) {
                        xPosition++;
                    }
                    break;

                case WEST:
                    if (isValidBackwardPosition(xPosition - 1)) {
                        xPosition--;
                    }
                    break;
            }

        }
    }

    public void left() {
        if (placeCommandHasBeenIssued) {
            changeDirection(Command.LEFT);
        }
    }

    public void right() {
        if (placeCommandHasBeenIssued) {
            changeDirection(Command.RIGHT);
        }

    }

    /**
     * 
     * @param command left or right command
     * 
     * This method changes the direction of the robot as per the given command
     */
    public void changeDirection(Command command) {

        switch (facingDirection) {

            case NORTH:
                facingDirection = command == Command.LEFT ? Direction.WEST : Direction.EAST;
                break;

            case SOUTH:
                facingDirection = command == Command.LEFT ? Direction.EAST : Direction.WEST;
                break;

            case EAST:
                facingDirection = command == Command.LEFT ? Direction.NORTH : Direction.SOUTH;
                break;

            case WEST:
                facingDirection = command == Command.LEFT ? Direction.SOUTH : Direction.NORTH;
                break;
        }
    }

    public String report() {
        if (placeCommandHasBeenIssued) {
            return String.format("x: %d, y: %d, direction: %s", xPosition, yPosition, 
                facingDirection.name());    
        }

        return "";
    }

    private boolean isValidForwardPosition(int position) {
        return position <= MAX_POSITION ? true : false;
    }

    private boolean isValidBackwardPosition(int position) {
        return position >= MIN_POSITION ? true : false;
    }
}

enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST
}

enum Command {
    LEFT,
    RIGHT,
    PLACE,
    MOVE,
    REPORT
}