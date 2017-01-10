package statepattern;

/**
 * Created by stillFox on 17/1/9.
 */
public class GumballMachine {
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    State state = soldOutState;
    int count = 0;

    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public String toString() {
        String machineInfo = "\nMighty Gumball, Inc.\nJava-enabled Standing Gumball Model #2004\nInventory: " + count + " gumballs\n";
        if (state == soldOutState) {
            machineInfo += "Machine is sold out";
        } else if (state == noQuarterState) {
            machineInfo += "Machine is waiting for quarter";
        } else if (state == hasQuarterState) {
            machineInfo += "Machine is waiting for turn";
        } else if (state == soldState) {
            machineInfo += "Machine is waiting for dispense";
        }
        machineInfo += "\n";
        return machineInfo;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public int getCount() {
        return count;
    }

    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }
}
