package breakout;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoreModel extends AbstractTableModel {

    ResultSet rs;
    int numberOfRows;
    int numberOfColumns;

    ScoreModel(ResultSet rs) {
        this.rs = rs;

        try {
            numberOfRows = 0;
            while(rs.next()){
                numberOfRows++;
            }

            numberOfColumns = rs.getMetaData().getColumnCount();
        } catch (SQLException se) {
            System.out.println(se.getMessage());
            System.exit(-1);
        }
    }

    @Override
    public int getRowCount(){
        return numberOfRows;
    }

    @Override
    public int getColumnCount(){
        return numberOfColumns;
    }

    @Override
    public Object getValueAt(int row, int col) {
        try {
            rs.absolute(row + 1);
            return rs.getObject(col + 1);
        } catch (SQLException se) {
            System.out.println(se.getMessage());
            return null;
        }
    }
}
