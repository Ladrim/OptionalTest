package org.alfonso.optional;

public class Optional
{
    public static void main(String[] args)
    {
        String nombre = "Alfonso";

        java.util.Optional<String> opt = java.util.Optional.of(nombre);
        System.out.println("opt = " + opt);
        System.out.println(opt.isPresent());

        if (opt.isPresent()) System.out.println("Hola " + opt.get());
        System.out.println(opt.isEmpty());
        opt.ifPresent(valor -> System.out.println("Hola " + valor));

        nombre = null;
        opt = java.util.Optional.ofNullable(nombre);

        System.out.println("opt = " + opt);
        System.out.println(opt.isPresent());
        System.out.println(opt.isEmpty());

        opt.ifPresent(valor -> System.out.println("Hola" + valor));
        opt.ifPresentOrElse(valor -> System.out.println("Hola" + valor), () -> System.out.println("No se encuentra"));

        opt.ifPresentOrElse(valor -> System.out.println("Hola" + valor), () -> System.out.println("No se encuentra"));

        java.util.Optional<String> optEmpty = java.util.Optional.empty();
        System.out.println("optEmpty = " + optEmpty);
        System.out.println(opt.isPresent());
    }
}