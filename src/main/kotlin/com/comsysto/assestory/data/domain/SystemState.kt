package com.comsysto.assestory.data.domain

data class SystemState(var online: Set<String>,
                       var offline: Set<String>)