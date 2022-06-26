package cts.mfpe.customer.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import cts.mfpe.customer.models.Requirement;

public interface RequirementRepository extends JpaRepository<Requirement, Integer> {

}
