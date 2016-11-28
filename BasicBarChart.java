import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.chart.XYChart.Data;
import javafx.stage.Stage;

public class BasicBarChart extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		String[] xData = {"Mon", "Tues", "Wed", "Thurs", "Fri"};
		double[] yData = {1.3, 2.1, 3.3, 4.0, 4.8};

		/* add Data to a Series */
		Series series = new Series();
		for (int i = 0; i < xData.length; i++){
			series.getData().add(new Data(xData[i], yData[i]));
		}

		/* define axes */
		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("X Values");
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Y Values");

		/* Create the bar chart */
		BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
		barChart.getData().add(series);

		/* create a scene using chart */
		Scene scene = new Scene(barChart, 800, 600);

		/* tell the stage what scene to use and render it */
		stage.setScene(scene);
		stage.show();
	}
}