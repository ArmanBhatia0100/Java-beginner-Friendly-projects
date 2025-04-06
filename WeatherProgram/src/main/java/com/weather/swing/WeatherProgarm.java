package com.weather.swing;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author arman
 */
public class WeatherProgarm implements ActionListener {

    JTextField jtextCity;
    JLabel jlabelTempResult;
    JLabel jlabelWindResult;
    String apiKey = "key=7336ccef67c846d4a0f02356250504";
    String city;
    String baseURL = "http://api.weatherapi.com/v1/current.json";

    public WeatherProgarm() {
        JFrame frame = Jframe();

        frame.add(weatherActionPanel(), BorderLayout.CENTER);
        frame.add(infoPanel(), BorderLayout.SOUTH);
        frame.pack();

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WeatherProgarm();

            }

        });

    }

    JFrame Jframe() {
        JFrame jf = new JFrame("Weather App");
        jf.setLayout(new BorderLayout());
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

        return jf;

    }

    JPanel weatherActionPanel() {
        JPanel actionPanel = new JPanel(new FlowLayout());
        actionPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel jlabelCity = new JLabel("City");
        jtextCity = new JTextField(15);
        JButton jbuttonGetWeather = new JButton("Get weather");
        jbuttonGetWeather.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                city = jtextCity.getText();
                getWeather();
            }

        });

        actionPanel.add(jlabelCity);
        actionPanel.add(jtextCity);
        actionPanel.add(jbuttonGetWeather);

        return actionPanel;
    }

    JPanel infoPanel() {

        JPanel infoPanel = new JPanel(new GridLayout(2, 2, -100, 5));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 15));

        JLabel jlabelTemp = new JLabel("Temp:");
        infoPanel.add(jlabelTemp);

        jlabelTempResult = new JLabel("51 degree cel");
        infoPanel.add(jlabelTempResult);

        JLabel jlabelWind = new JLabel("Wind Speed:");
        infoPanel.add(jlabelWind);

        jlabelWindResult = new JLabel("100/kmh");
        infoPanel.add(jlabelWindResult);

        return infoPanel;
    }

    void getWeather() {
        String weatherApi = "?key=7336ccef67c846d4a0f02356250504&q=" + city + "&aqi=no";
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseURL + weatherApi))
                .GET() // Use .POST(), .PUT(), etc., if needed
                .build();

        try {
            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String jsonResponse = response.body();
            JSONObject jsonObj = new JSONObject(jsonResponse);

            double temp = (Double) jsonObj.getJSONObject("current").get("temp_c");
            double wind_kph = (Double) jsonObj.getJSONObject("current").get("wind_kph");
//            System.out.println(temp);

            jlabelTempResult.setText(temp + " Degree Celcius");
            jlabelWindResult.setText(wind_kph + " Km/h");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
