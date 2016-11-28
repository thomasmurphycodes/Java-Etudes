import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.chart.XYChart.Data;
import javafx.stage.Stage;

public class BasicScatterChart extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		int[] xData = {1,2,3,4,5};
		double[] yData = {1.3, 2.1, 3.3, 4.0, 4.8};

		/* Add Data into the series object */
		Series series = new Series();
		for (int i = 0; i < xData.length; i++) {
			series.getData().add(new Data(xData[i], yData[i]));

		}

		/* Define axes */
		NumberAxis xAxis = new NumberAxis();
		xAxis.setLabel("X values");
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Y values");

		/* Create scatter chart */
		ScatterChart<Number, Number> scatterChart = new ScatterChart<>(xAxis, yAxis);
		scatterChart.getData().add(series);

		/* create scene using the cahrt */
		Scene scene = new Scene(scatterChart, 800, 600);
		stage.setScene(scene);
		stage.show();
	}
}