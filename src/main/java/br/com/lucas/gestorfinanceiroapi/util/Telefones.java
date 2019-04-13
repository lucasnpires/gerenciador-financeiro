package br.com.lucas.gestorfinanceiroapi.util;


import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import br.com.twsoftware.alfred.texto.Texto;

public final class Telefones {

     public static String formatar(String telefone) {

          final String soNumeros = Texto.manterNumeros(telefone);
          final StringBuilder s = new StringBuilder();

          if (soNumeros.length() == 10) {
               s.append("(");
               s.append(soNumeros, 0, 2);
               s.append(") ");
               s.append(soNumeros, 2, 6);
               s.append("-");
               s.append(soNumeros, 6, 10);
          }

          if (soNumeros.length() == 11) {
               s.append("(");
               s.append(soNumeros, 0, 2);
               s.append(") ");
               s.append(soNumeros, 2, 7);
               s.append("-");
               s.append(soNumeros, 7, 11);
          }

          return s.length() == 0 ? telefone : s.toString();
     }

     public static boolean isValido(String telefone) {

          Pattern fonePattern = Pattern.compile("(\\([0-9]{2}\\)\\s?)?[0-9]{4,5}\\-?[0-9]{4}");
          return fonePattern.matcher(telefone).matches();
     }

     public static boolean tamanhoValido(final String texto, final TelefonesTamanho telefones) {

          return texto.length() == telefones.getTamanho();
     }
     
     public static String mascarar(final String telefone) {
          
          final String telefoneFormatado = formatar(telefone);
          int sizeDdd = telefoneFormatado.contains(")") ? 4 : 2;
          int index = telefoneFormatado.length() - 4;
          
          final String telefoneMascarado = telefoneFormatado.substring(0, sizeDdd) + StringUtils.leftPad(telefoneFormatado.substring(index), 9, "x");
          
          return telefoneMascarado;
     }

}
