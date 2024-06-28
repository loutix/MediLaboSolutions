package com.ocr.assessment_service.constants;

import java.util.Arrays;
import java.util.List;


public enum Keyword {
    HEMOGLOBINE("Hémoglobine A1C"),
    MICROALBUMINE("Microalbumine"),
    TAILLE("Taille"),
    POIDS("Poids"),
    FUMEUR("Fumeur"),
    FUMEUSE("Fumeuse"),
    ANOMRAL("Anormal"),
    CHOLESTEROL("Cholestérol"),
    VERTIGES("Vertiges"),
    RECHUTE("Rechute"),
    REACTION("Réaction"),
    ANTICORPS("Anticorps");

    private final String keyword;

    Keyword(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public static List<String> getAllKeywords() {
        return Arrays.stream(Keyword.values())
                .map(Keyword::getKeyword)
                .toList();
    }

}
