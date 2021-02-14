package co.za.kaylen.pillay.valorantagentguide.utils

import java.lang.reflect.Constructor

@Suppress("UNCHECKED_CAST")
fun <T> Class<T>.findMatchingConstructor(constructorSignature: List<Class<*>>): Constructor<T>? {
    constructors.forEach { constructor ->
        if (constructor.parameterTypes.equals(constructorSignature)) {
            return constructor as Constructor<T>
        }
    }
    return null
}