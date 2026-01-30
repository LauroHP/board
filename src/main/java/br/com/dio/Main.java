package br.com.dio;

import br.com.dio.persistence.migration.MigrationStrategy;
import br.com.dio.ui.MainMenu;

import static br.com.dio.persistence.config.ConnectionConfig.getConnection;


public class Main {

    public static void main(String[] args) {
        try(var connection = getConnection()){
            new MigrationStrategy(connection).executeMigration();
        } catch (Exception ex) {
            System.err.println("Erro ao executar as migrations: " + ex.getMessage());
            return;
        }
        try {
            new MainMenu().execute();
        } catch (Exception ex) {
            System.err.println("Erro ao iniciar o menu principal: " + ex.getMessage());
        }
    }

}
