package com.viona.core.state

import kotlinx.coroutines.flow.Flow

typealias FlowState<T> = Flow<StateEvent<T>>