//package com.deminmax;
//
//import java.util.Comparator;
//
//public interface Lines extends Comparator<Line> {
//
//    @Override
//    default Comparator<Line> thenComparing(Comparator<? super Line> other) {
//        return Comparator.comparing(Line::getNumber);
//    }
//}
