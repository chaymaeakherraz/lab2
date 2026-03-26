package com.example.lab2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText surfaceInput, piecesInput;
    private CheckBox piscineCheckbox;
    private TextView resultView;
    private Button buttonCalcul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Liaison avec XML
        surfaceInput = findViewById(R.id.input_surface);
        piecesInput = findViewById(R.id.input_pieces);
        piscineCheckbox = findViewById(R.id.checkbox_piscine);
        resultView = findViewById(R.id.result);
        buttonCalcul = findViewById(R.id.button_calcul);

        // Click bouton
        buttonCalcul.setOnClickListener(v -> calculer());
    }

    private void calculer() {

        // Vérification champs vides
        if (TextUtils.isEmpty(surfaceInput.getText()) ||
                TextUtils.isEmpty(piecesInput.getText())) {

            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            // Conversion
            double surface = Double.parseDouble(surfaceInput.getText().toString());
            int pieces = Integer.parseInt(piecesInput.getText().toString());
            boolean piscine = piscineCheckbox.isChecked();

            // Calcul
            double impotBase = surface * 2;
            double supplement = pieces * 50 + (piscine ? 100 : 0);
            double total = impotBase + supplement;

            // Affichage
            resultView.setText("Impôt total : " + total + " DH");

        } catch (Exception e) {
            Toast.makeText(this, "Erreur dans les valeurs saisies", Toast.LENGTH_SHORT).show();
        }
    }
}