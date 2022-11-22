public class TableRow {
    String symbol;
    int index, addr;

    public TableRow(String symbol, int addr) {
        this.symbol = symbol;
        this.addr = addr;
        index = 0;
    }

    public TableRow(String symbol, int addr, int index) {
        this.symbol = symbol;
        this.addr = addr;
        this.index = index;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setAddress(int addr) {
        this.addr = addr;
    }

    public int getAddress() {
        return addr;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
