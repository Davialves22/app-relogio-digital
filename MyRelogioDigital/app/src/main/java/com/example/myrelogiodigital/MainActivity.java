package com.example.myrelogiodigital;

// Importa a classe Bundle para armazenar o estado da Activity.

import android.os.Bundle;

// Importa o componente Button.
import android.view.View;
import android.widget.Button;

// Importa o componente TextClock, responsável por exibir a hora do sistema.
import android.widget.TextClock;

// Importa o componente TextView.
import android.widget.TextView;

// Importa recursos para trabalhar com Edge-to-Edge.
import androidx.activity.EdgeToEdge;

// Classe base para Activities que utilizam recursos da AppCompat.
import androidx.appcompat.app.AppCompatActivity;

// Importa a classe Insets para controlar margens do sistema.
import androidx.core.graphics.Insets;

// Importa utilitário para manipular a interface.
import androidx.core.view.ViewCompat;

// Importa recursos para trabalhar com barras do sistema.
import androidx.core.view.WindowInsetsCompat;

// Classe principal da aplicação.
public class MainActivity extends AppCompatActivity {

    // Declara o componente que exibe a hora atual.
    TextClock textClockHora;

    // Declara o TextView onde será mostrada a hora capturada.
    TextView textHoraAtual;

    // Declara o botão responsável por capturar a hora.
    Button btnCapturar;

    // Método executado quando a Activity é criada.
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Chama o método da classe pai.
        super.onCreate(savedInstanceState);

        // Ativa o modo Edge-to-Edge.
        EdgeToEdge.enable(this);

        // Define o layout da tela.
        setContentView(R.layout.activity_main);

        // Ajusta automaticamente o espaçamento da tela considerando
        // a barra de status e a barra de navegação.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {

            // Obtém as dimensões das barras do sistema.
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

            // Aplica os espaçamentos ao componente.
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            // Retorna os valores dos Insets.
            return insets;
        });

        // Inicializa todos os componentes da interface.
        DeclaraComponentes();

        // Configura a ação do botão.
        CapturarHora();
    }

    // Método responsável por configurar o clique do botão.
    private void CapturarHora() {

        // Define o evento de clique do botão.
        btnCapturar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Captura a hora atual do TextClock e exibe no TextView.
                textHoraAtual.setText("Hora capturada: " + textClockHora.getText());
            }
        });
    }

    // Método responsável por associar as variáveis Java
    // aos componentes do arquivo activity_main.xml.
    private void DeclaraComponentes() {

        // Liga a variável ao TextClock do XML.
        textClockHora = findViewById(R.id.textClock);

        // Liga a variável ao TextView do XML.
        textHoraAtual = findViewById(R.id.textHoraAtual);

        // Liga a variável ao botão do XML.
        btnCapturar = findViewById(R.id.btnCapturar);
    }
}