package ippo.assignment.model;

public enum WallDirection {
    North, East, South, West;

    public WallDirection Left(){
        switch (this){
            case South -> {
                return East;
            }
            case East -> {
                return North;
            }
            case North -> {
                return West;
            }
            case West -> {
                return South;
            }
        }
        return null;
    }

    public WallDirection Right(){
        switch (this){
            case East -> {
                return South;
            }
            case South -> {
                return West;
            }
            case West -> {
                return North;
            }
            case North -> {
                return East;
            }
        }
        return null;
    }
}
