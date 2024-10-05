
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.Calculadora;

public class CalculadoraTeste {
    Calculadora calc = new Calculadora();
    @Test
    public void testeSoma() {
        double resultadoEsperado = 11;
        double resultadoObtido = calc.soma(3, 8);
        // assert resultadoObtido == resultadoEsperado;
        assertEquals(resultadoEsperado, resultadoObtido, 0);
    }
    
    @Test
    public void testeSubtracao() {
        double resultadoEsperado = 5;
        double resultadoObtido = calc.subtracao(10, 5);
        assertEquals(resultadoEsperado, resultadoObtido, 0);
    }
    
    @Test
    public void testeMultiplicacao() {
        double resultadoEsperado = 40;
        double resultadoObtido = calc.multiplicacao(10, 4);
        assertEquals(resultadoEsperado, resultadoObtido, 0);
    }
    
    @Test
    public void testeDivisao() {
        double resultadoEsperado = 2.5;
        double resultadoObtido = calc.divisao(5, 2);
        assertEquals(resultadoEsperado, resultadoObtido, 0);
    }
   
}