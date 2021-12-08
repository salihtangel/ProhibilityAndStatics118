import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public   class BarChart_AWT extends ApplicationFrame {

    public BarChart_AWT( String applicationTitle , String chartTitle ) {
        super( applicationTitle );
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Category",
                "Score",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel( barChart );
        chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
    }

    private CategoryDataset createDataset( ) {
        final String estimated = "ESTIMATED";
        final String real = "REAL";
        final String ford = "FORD";
        final String zero = "zero";
        final String two = "two";
        final String one = "one";
        final String three = "three";
        final String four = "four";
        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset( );

        dataset.addValue( 139.04 , estimated , zero );
        dataset.addValue(  97.33 , estimated , one );
        dataset.addValue(  34.06 , estimated , two );
        dataset.addValue(   7.94 , estimated , three );
        dataset.addValue(     1.39, estimated , four );

        dataset.addValue( 144 , real , zero );
        dataset.addValue(  91 , real , one );
        dataset.addValue(  32	 , real , two );
        dataset.addValue( 11 , real , three );
        dataset.addValue( 2 , real , four);



        return dataset;
    }

    public static void main( String[ ] args ) {
        BarChart_AWT chart = new BarChart_AWT("Car Usage Statistics",
                "Which car do you like?");
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }
}