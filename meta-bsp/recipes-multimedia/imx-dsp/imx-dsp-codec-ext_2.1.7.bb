# Copyright 2018-2021,2023 NXP

DESCRIPTION = "i.MX DSP Codec Wrapper and Lib owned by NXP"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=2827219e81f28aba7c6a569f7c437fa7" 

inherit fsl-eula-unpack autotools pkgconfig

SRC_URI = "${FSL_MIRROR}/${BP}.bin;fsl-eula=true"

SRC_URI[md5sum] = "77f2ef394610640dff80bbaf9088d748"
SRC_URI[sha256sum] = "cbf28b72e8de3355561896ff58d741e90e8dec3c124afcb609b3af65f3b344ea"

# Fix strip command failed: 'Unable to recognise the format of the input file'
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_SYSROOT_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INSANE_SKIP:${PN} = "arch dev-so ldflags"

EXTRA_OECONF:append:mx8qm-nxp-bsp = " --enable-imx8qmqxp"
EXTRA_OECONF:append:mx8qxp-nxp-bsp = " --enable-imx8qmqxp"
EXTRA_OECONF:append:mx8dx-nxp-bsp = " --enable-imx8qmqxp"
EXTRA_OECONF:append:mx8mp-nxp-bsp = " --enable-imx8m"
EXTRA_OECONF:append:mx8ulp-nxp-bsp = " --enable-imx8ulp"

FILES:${PN} += "${libdir}/imx-mm/audio-codec/dsp ${datadir}/imx-mm"
COMPATIBLE_MACHINE = "(mx8qm-nxp-bsp|mx8qxp-nxp-bsp|mx8dx-nxp-bsp|mx8mp-nxp-bsp|mx8ulp-nxp-bsp)"