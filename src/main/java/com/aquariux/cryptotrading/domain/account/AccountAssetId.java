package com.aquariux.cryptotrading.domain.account;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountAssetId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String accId;
	private String assetId;
	
	public AccountAssetId(String accId, String assetId) {
		super();
		this.accId = accId;
		this.assetId= assetId;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountAssetId id = (AccountAssetId) o;
        return accId.equals(id.accId) &&
        		assetId.equals(id.assetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accId, assetId);
    }

}
