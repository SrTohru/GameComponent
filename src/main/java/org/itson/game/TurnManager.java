package org.itson.game;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.itson.domaincomponent.domain.Player;

public class TurnManager {

    private static TurnManager turnManager;

    private Map<Player, Integer> playersTurnsList = new HashMap<>();

    private int actualTurn;

    public void generateTurns(Player[] players) {
        
        /*
        Si la lista contiene algun dato al generar lus turnos, la lista se limpia
        */
        if(playersTurnsList != null){
            playersTurnsList.clear();
        } 
        
        /*
        Aqui se mantienen los turnos y cuando se agreguen a un jugador se iran eliminando
        */
        List<Integer> availableTurns = new ArrayList<>();
        for (int i = 1; i <= players.length; i++) {
            availableTurns.add(i);
        }
        
        Collections.shuffle(availableTurns, new Random());

        for (Player player : players) {
            int turn = availableTurns.remove(0);
            playersTurnsList.put(player, turn);
        }

        // Ordena la lista por los turnos asignados en orden inverso
        List<Map.Entry<Player, Integer>> sortedList = new ArrayList<>(playersTurnsList.entrySet());
        
        sortedList.sort(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));

        // Limpia el HashMap y vuelve a agregar los elementos ordenados
        playersTurnsList.clear();
        for (Map.Entry<Player, Integer> entry : sortedList) {
            setTurnToPlayer(entry.getKey(), entry.getValue());
        }
    }

    public void setTurnToPlayer(Player player, Integer turn) {
        playersTurnsList.put(player, turn);
        sortPlayersByTurn();
    }

    private void sortPlayersByTurn() {
        // Ordena la lista por los turnos asignados en orden inverso
        List<Map.Entry<Player, Integer>> sortedList = new ArrayList<>(playersTurnsList.entrySet());
        sortedList.sort(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));

        // Limpia el HashMap y vuelve a agregar los elementos ordenados
        playersTurnsList.clear();
        for (Map.Entry<Player, Integer> entry : sortedList) {
            playersTurnsList.put(entry.getKey(), entry.getValue());
        }
    }

    public boolean verifyActualPlayerTurn(Player player) {
        Integer playerTurn = playersTurnsList.get(player);
        return playerTurn != null && playerTurn.equals(actualTurn);
    }

    public void printTurns() {
        System.out.println("Turnos de los jugadores:");
        for (Map.Entry<Player, Integer> entry : playersTurnsList.entrySet()) {
            Player player = entry.getKey();
            Integer turn = entry.getValue();
            System.out.println(player.getName() + ": " + (turn != null ? turn : "Sin asignar"));
        }
    }

    public void passTurn() {
        if ((actualTurn + 1) > playersTurnsList.size()) {
            actualTurn = (playersTurnsList.size() - (playersTurnsList.size() - 1));
        } else {
            actualTurn++;
        }
    }

    public void eliminatePlayerFromTurnList(Player player) {
        playersTurnsList.remove(player);
        actualTurn--;
    }

    public static TurnManager getInstance() {
        if (turnManager == null) {
            turnManager = new TurnManager();
        }
        return turnManager;
    }
}
