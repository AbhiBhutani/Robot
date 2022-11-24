class Table {
    
    private static Table table = null;



    private Table() {

    }

    public static Table getInstance() {
        if(table == null) {
            table = new Table();
        }

        return table;
    }







}
