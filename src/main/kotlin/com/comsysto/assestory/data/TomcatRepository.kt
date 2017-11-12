package com.comsysto.assestory.data

import com.comsysto.assestory.data.domain.TomcatInstance
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TomcatRepository : CrudRepository<TomcatInstance, String>