package Cronometro;

import org.jdesktop.swingx.JXLabel;
import org.jdesktop.swingx.JXTextField;

public class Cronometro extends Thread {

    private final JXTextField jxtfCron;
    private final JXLabel jxlTempo;

    public Cronometro(JXTextField jxtfCron, JXLabel jxlTempo) {
        this.jxtfCron = jxtfCron;
        this.jxlTempo = jxlTempo;
    }

    @Override
    public void run() {
        int hr = 0, min = 0, seg = 0;

        while (!jxlTempo.getText().equals(jxtfCron.getText())) {

            try {
                if (min == 60) {
                    min = 0;
                    hr++;
                }

                if (seg == 60) {
                    seg = 0;
                    min++;
                }

                jxtfCron.setText(formataCronometro(hr, min, seg));

                seg++;

                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }

    public String formataCronometro(int horas, int minutos, int segundos) {
        String tempoHoras, tempoMinutos, tempoSegundos;

        if (horas < 10) {
            tempoHoras = "0" + horas;
        } else {
            tempoHoras = "" + horas;
        }

        if (minutos < 10) {
            tempoMinutos = "0" + minutos;
        } else {
            tempoMinutos = "" + minutos;
        }

        if (segundos < 10) {
            tempoSegundos = "0" + segundos;
        } else {
            tempoSegundos = "" + segundos;
        }

        return tempoHoras + ":" + tempoMinutos + ":" + tempoSegundos;
    }
}
