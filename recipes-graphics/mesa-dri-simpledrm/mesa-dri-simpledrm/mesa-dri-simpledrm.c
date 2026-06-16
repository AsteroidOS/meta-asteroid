#include <dlfcn.h>

/*
This is a temporary hack until Mesa upstream adds 2 lines to their code.
https://gitlab.freedesktop.org/mesa/mesa/-/issues/8929
*/

void* __driDriverGetExtensions_simpledrm(void)
{
    /*
     * NOTE: This does NOT require a Mediatek GPU.
     * We fall back to software rendering.
     * This just returns extensions for the simpledrm shim.
     */
    static void*(*ddge_mediatek)(void);
    if(!ddge_mediatek)
        ddge_mediatek = dlsym(dlopen("/usr/lib/dri/mediatek_dri.so", RTLD_NOW), "__driDriverGetExtensions_mediatek");
    return ddge_mediatek();
}
