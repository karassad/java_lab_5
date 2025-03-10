package sort;

import model.Organization;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;

public class SortByAT {

    public static LinkedHashSet<Organization> sortAT(LinkedHashSet<Organization> organizations){

        ArrayList<Organization> sortedList = new ArrayList<>(organizations);
        sortedList.sort(new AnnualTurnoverComparator());

        return new LinkedHashSet<>(sortedList);

    }

    public static class AnnualTurnoverComparator implements Comparator<Organization> {
        @Override
        public int compare(Organization org1, Organization org2) {
            if (org1.getAnnualTurnover() == null && org2.getAnnualTurnover() == null) {
                return 0; // Оба значения null, считаем равными
            } else if (org1.getAnnualTurnover() == null) {
                return 1; // Если у первого объекта null, он меньше второго (по убыванию)
            } else if (org2.getAnnualTurnover() == null) {
                return -1; // Если у второго объекта null, он меньше первого (по убыванию)
            }
            // Сравниваем по убыванию (меняем порядок аргументов)
            return Double.compare(org2.getAnnualTurnover(), org1.getAnnualTurnover());
        }
    }

}
