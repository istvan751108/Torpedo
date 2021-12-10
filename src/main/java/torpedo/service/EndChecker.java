package torpedo.service;

import torpedo.model.MapVO;

public class EndChecker {
    private final MapVO mapVOChecker02;
    private final MapVO mapVOChecker01;
    boolean endPlay=false;
    int counterPlayer01, counterPlayer02;
    public EndChecker(MapVO mapVOChecker02, MapVO mapVOChecker01) {
        this.mapVOChecker02 = mapVOChecker02;
        this.mapVOChecker01 = mapVOChecker01;
    }

    public boolean endCheckerPlayer01() {
        char[][] table = mapVOChecker02.getMap();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (table[i][j] == 'T') {
                    counterPlayer01++;
                }
            }
        }
        if (counterPlayer01==15) {
            System.out.println("Minden hajó elsüllyedt! Győzött az 1. játékos!");
            endPlay = true;
        }
        return endPlay;
    }
    public boolean endCheckerPlayer02() {
        char[][] table = mapVOChecker01.getMap();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (table[i][j] == 'T') {
                    counterPlayer02++;
                }
            }
        }
        if (counterPlayer02==15){
            System.out.println("Minden hajó elsüllyedt! Győzött a 2. játékos!");
            endPlay=true;
        }
        return endPlay;
    }
}
