package ids;

import java.util.Objects;

public class ComboIDProduto implements IdProduto {
    private String nomeCombo;
    private String descricaoCombo;

    public ComboIDProduto(String nomeCombo, String descricaoCombo) {
        this.nomeCombo = nomeCombo;
        this.descricaoCombo = descricaoCombo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComboIDProduto comboID = (ComboIDProduto) o;
        return Objects.equals(nomeCombo, comboID.nomeCombo) &&
                Objects.equals(descricaoCombo, comboID.descricaoCombo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nomeCombo, descricaoCombo);
    }
}
