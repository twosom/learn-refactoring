package com.icloud.refactoring._11_primitive_obsession._03_replace_conditional_with_polymorphism.variation;

import java.util.List;

public class RatingFactory {
    public static VoyageRating createRating(Voyage voyage, List<VoyageHistory> history) {
        return isChinaVoyageRating(voyage, history) ?
                new ChinaExperiencedVoyageRating(voyage, history) :
                new VoyageRating(voyage, history);
    }

    private static boolean isChinaVoyageRating(Voyage voyage, List<VoyageHistory> history) {
        return voyage.zone().equals("china") && hasChinaHistory(history);
    }

    private static boolean hasChinaHistory(List<VoyageHistory> history) {
        return history.stream().anyMatch(v -> v.zone().equals("china"));
    }
}
