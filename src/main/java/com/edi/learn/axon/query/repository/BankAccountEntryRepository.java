
package com.edi.learn.axon.query.repository;

import com.edi.learn.axon.query.entries.BankAccountEntry;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "bankAccounts", path = "bankAccounts")
public interface BankAccountEntryRepository extends PagingAndSortingRepository<BankAccountEntry, String> {

}

