#include "normalRound.h"
#define SK_BITASSIGN(a,i,x) a=((a)&(~(1<<(i))))|(((x)&1)<<(i))
void normalRoundsk(unsigned int* _in, unsigned int* rkey, unsigned int* _out_0) { // normalRound.sk:6
  { // normalRound.sk:6
	  unsigned int in[4];
    unsigned int T0[256]; // normalRound.sk:7
    for (unsigned int __sa45 = 0; (__sa45 < 256); __sa45++) T0[__sa45] = 0; // normalRound.sk:7
    T0[0] = 0x6178b0ee; // normalRound.sk:7
    T0[1] = 0x4067afd0; // normalRound.sk:7
    T0[2] = 0x5d6ca4c6; // normalRound.sk:7
    T0[3] = 0x4960a8de; // normalRound.sk:7
    T0[4] = 0xc9e921d7; // normalRound.sk:7
    T0[5] = 0x7970b8fe; // normalRound.sk:7
    T0[6] = 0x7574bcf6; // normalRound.sk:7
    T0[7] = 0x90de16b9; // normalRound.sk:7
    T0[8] = 0x942be348; // normalRound.sk:7
    T0[9] = 0xc71ad22a; // normalRound.sk:7
    T0[10] = 0x6d7cb4e6; // normalRound.sk:7
    T0[11] = 0xb930f87e; // normalRound.sk:7
    T0[12] = 0xdde52dcf; // normalRound.sk:7
    T0[13] = 0xa6cc049d; // normalRound.sk:7
    T0[14] = 0x22b07865; // normalRound.sk:7
    T0[15] = 0x5e6da5c4; // normalRound.sk:7
    T0[16] = 0x81d119a7; // normalRound.sk:7
    T0[17] = 0x59995137; // normalRound.sk:7
    T0[18] = 0x84d21aa1; // normalRound.sk:7
    T0[19] = 0x4366aed2; // normalRound.sk:7
    T0[20] = 0xd1e129c7; // normalRound.sk:7
    T0[21] = 0x2f428a9a; // normalRound.sk:7
    T0[22] = 0xd5c94a6; // normalRound.sk:7
    T0[23] = 0xcfeb23d3; // normalRound.sk:7
    T0[24] = 0x28b67e69; // normalRound.sk:7
    T0[25] = 0xa3cf079b; // normalRound.sk:7
    T0[26] = 0x39b97177; // normalRound.sk:7
    T0[27] = 0x2eb47c6d; // normalRound.sk:7
    T0[28] = 0x7b874f0b; // normalRound.sk:7
    T0[29] = 0x33bf777b; // normalRound.sk:7
    T0[30] = 0x5269a1cc; // normalRound.sk:7
    T0[31] = 0x9fdb13b3; // normalRound.sk:7
    T0[32] = 0x6ac645d; // normalRound.sk:7
    T0[33] = 0xd8e62ec9; // normalRound.sk:7
    T0[34] = 0x6a884015; // normalRound.sk:7
    T0[35] = 0xae3df564; // normalRound.sk:7
    T0[36] = 0x9e2de544; // normalRound.sk:7
    T0[37] = 0x8524ec56; // normalRound.sk:7
    T0[38] = 0xc6ec24dd; // normalRound.sk:7
    T0[39] = 0x8bd71fab; // normalRound.sk:7
    T0[40] = 0x982fe740; // normalRound.sk:7
    T0[41] = 0x30be7679; // normalRound.sk:7
    T0[42] = 0xf0fe36f9; // normalRound.sk:7
    T0[43] = 0xccea22d1; // normalRound.sk:7
    T0[44] = 0x576aa2ca; // normalRound.sk:7
    T0[45] = 0xb7c30b83; // normalRound.sk:7
    T0[46] = 0x972ae24a; // normalRound.sk:7
    T0[47] = 0xfb0ec602; // normalRound.sk:7
    T0[48] = 0xc81fd720; // normalRound.sk:7
    T0[49] = 0x96dc14bd; // normalRound.sk:7
    T0[50] = 0xa138f06e; // normalRound.sk:7
    T0[51] = 0x9ad810b5; // normalRound.sk:7
    T0[52] = 0xec03cb18; // normalRound.sk:7
    T0[53] = 0x658d451f; // normalRound.sk:7
    T0[54] = 0xcb1ed622; // normalRound.sk:7
    T0[55] = 0x71814907; // normalRound.sk:7
    T0[56] = 0xcd1cd426; // normalRound.sk:7
    T0[57] = 0xf209c10c; // normalRound.sk:7
    T0[58] = 0x5f9b5333; // normalRound.sk:7
    T0[59] = 0xf9f931f7; // normalRound.sk:7
    T0[60] = 0xe2f038e5; // normalRound.sk:7
    T0[61] = 0xad3cf466; // normalRound.sk:7
    T0[62] = 0x9a96157; // normalRound.sk:7
    T0[63] = 0x5b6ea6c2; // normalRound.sk:7
    T0[64] = 0xdf12da3a; // normalRound.sk:7
    T0[65] = 0x5a985035; // normalRound.sk:7
    T0[66] = 0xb037ff70; // normalRound.sk:7
    T0[67] = 0xea01c91c; // normalRound.sk:7
    T0[68] = 0xe900c81e; // normalRound.sk:7
    T0[69] = 0x7675bdf4; // normalRound.sk:7
    T0[70] = 0x2a41899c; // normalRound.sk:7
    T0[71] = 0x3fbb7373; // normalRound.sk:7
    T0[72] = 0x3249818c; // normalRound.sk:7
    T0[73] = 0x8920e85e; // normalRound.sk:7
    T0[74] = 0xa5cd059f; // normalRound.sk:7
    T0[75] = 0xaa86055; // normalRound.sk:7
    T0[76] = 0xbf32fa7a; // normalRound.sk:7
    T0[77] = 0xfaf830f5; // normalRound.sk:7
    T0[78] = 0xb534fc76; // normalRound.sk:7
    T0[79] = 0x539f573b; // normalRound.sk:7
    T0[80] = 0x3148808e; // normalRound.sk:7
    T0[81] = 0xacca0291; // normalRound.sk:7
    T0[82] = 0xc41bd328; // normalRound.sk:7
    T0[83] = 0xe8f63ee9; // normalRound.sk:7
    T0[84] = 0xa43bf368; // normalRound.sk:7
    T0[85] = 0xdbe72fcb; // normalRound.sk:7
    T0[86] = 0xcaa6251; // normalRound.sk:7
    T0[87] = 0x2940889e; // normalRound.sk:7
    T0[88] = 0x7a71b9fc; // normalRound.sk:7
    T0[89] = 0x82d018a5; // normalRound.sk:7
    T0[90] = 0x1da56d4f; // normalRound.sk:7
    T0[91] = 0x8f22ea5a; // normalRound.sk:7
    T0[92] = 0x1a5199bc; // normalRound.sk:7
    T0[93] = 0x10579fb0; // normalRound.sk:7
    T0[94] = 0x2c438b98; // normalRound.sk:7
    T0[95] = 0x8ed41cad; // normalRound.sk:7
    T0[96] = 0xafcb0393; // normalRound.sk:7
    T0[97] = 0xeef43ced; // normalRound.sk:7
    T0[98] = 0x21b17967; // normalRound.sk:7
    T0[99] = 0xd2e028c5; // normalRound.sk:7
    T0[100] = 0x15890ae; // normalRound.sk:7
    T0[101] = 0x13569eb2; // normalRound.sk:7
    T0[102] = 0x9128e04e; // normalRound.sk:7
    T0[103] = 0x509e5639; // normalRound.sk:7
    T0[104] = 0xb5e96a2; // normalRound.sk:7
    T0[105] = 0xd4e22ac1; // normalRound.sk:7
    T0[106] = 0xc219d12c; // normalRound.sk:7
    T0[107] = 0x4564acd6; // normalRound.sk:7
    T0[108] = 0x344b8388; // normalRound.sk:7
    T0[109] = 0x8027ef50; // normalRound.sk:7
    T0[110] = 0x7e844c0d; // normalRound.sk:7
    T0[111] = 0x27b37b63; // normalRound.sk:7
    T0[112] = 0x374a828a; // normalRound.sk:7
    T0[113] = 0x3ab87075; // normalRound.sk:7
    T0[114] = 0x45b93a8; // normalRound.sk:7
    T0[115] = 0x4e945c2d; // normalRound.sk:7
    T0[116] = 0x69894117; // normalRound.sk:7
    T0[117] = 0x78864e09; // normalRound.sk:7
    T0[118] = 0x8c23eb58; // normalRound.sk:7
    T0[119] = 0xc0ee26d9; // normalRound.sk:7
    T0[120] = 0x1ba76f4b; // normalRound.sk:7
    T0[121] = 0x5ad655f; // normalRound.sk:7
    T0[122] = 0xb1c10987; // normalRound.sk:7
    T0[123] = 0xa73af26a; // normalRound.sk:7
    T0[124] = 0xf40bc308; // normalRound.sk:7
    T0[125] = 0xdee42ccd; // normalRound.sk:7
    T0[126] = 0xcae820d5; // normalRound.sk:7
    T0[127] = 0xa9c90197; // normalRound.sk:7
    T0[128] = 0x88d61ea9; // normalRound.sk:7
    T0[129] = 0xd017df30; // normalRound.sk:7
    T0[130] = 0xf108c00e; // normalRound.sk:7
    T0[131] = 0xebf73feb; // normalRound.sk:7
    T0[132] = 0x25448c96; // normalRound.sk:7
    T0[133] = 0x668c441d; // normalRound.sk:7
    T0[134] = 0x85f97a0; // normalRound.sk:7
    T0[135] = 0xfd0cc406; // normalRound.sk:7
    T0[136] = 0xffffffff; // normalRound.sk:7
    T0[137] = 0x36bc747d; // normalRound.sk:7
    T0[138] = 0x4665add4; // normalRound.sk:7
    T0[139] = 0x8326ee52; // normalRound.sk:7
    T0[140] = 0x687fb7e0; // normalRound.sk:7
    T0[141] = 0x23468e92; // normalRound.sk:7
    T0[142] = 0xef02ca1a; // normalRound.sk:7
    T0[143] = 0x5168a0ce; // normalRound.sk:7
    T0[144] = 0x647bb3e8; // normalRound.sk:7
    T0[145] = 0x5c9a5231; // normalRound.sk:7
    T0[146] = 0x15549cb6; // normalRound.sk:7
    T0[147] = 0xbbc70f8b; // normalRound.sk:7
    T0[148] = 0xa239f16c; // normalRound.sk:7
    T0[149] = 0xba31f97c; // normalRound.sk:7
    T0[150] = 0x6f8b4313; // normalRound.sk:7
    T0[151] = 0x47935b23; // normalRound.sk:7
    T0[152] = 0xe5d95a4; // normalRound.sk:7
    T0[153] = 0xedf53def; // normalRound.sk:7
    T0[154] = 0x17a36b43; // normalRound.sk:7
    T0[155] = 0xf80fc700; // normalRound.sk:7
    T0[156] = 0xbdc50d8f; // normalRound.sk:7
    T0[157] = 0x26458d94; // normalRound.sk:7
    T0[158] = 0xd910d83e; // normalRound.sk:7
    T0[159] = 0xb2c00885; // normalRound.sk:7
    T0[160] = 0xfffb33f3; // normalRound.sk:7
    T0[161] = 0x9229e14c; // normalRound.sk:7
    T0[162] = 0x8a21e95c; // normalRound.sk:7
    T0[163] = 0xda11d93c; // normalRound.sk:7
    T0[164] = 0x1f529aba; // normalRound.sk:7
    T0[165] = 0xce1dd524; // normalRound.sk:7
    T0[166] = 0xa83ff760; // normalRound.sk:7
    T0[167] = 0x20478f90; // normalRound.sk:7
    T0[168] = 0x99d911b7; // normalRound.sk:7
    T0[169] = 0xaac80095; // normalRound.sk:7
    T0[170] = 0x2bb77f6b; // normalRound.sk:7
    T0[171] = 0x6279b1ec; // normalRound.sk:7
    T0[172] = 0x6c8a4211; // normalRound.sk:7
    T0[173] = 0x608e4619; // normalRound.sk:7
    T0[174] = 0xf3ff37fb; // normalRound.sk:7
    T0[175] = 0x4f62aada; // normalRound.sk:7
    T0[176] = 0xf6fc34fd; // normalRound.sk:7
    T0[177] = 0x87d31ba3; // normalRound.sk:7
    T0[178] = 0x9d2ce446; // normalRound.sk:7
    T0[179] = 0x7376bef2; // normalRound.sk:7
    T0[180] = 0x48965e29; // normalRound.sk:7
    T0[181] = 0xa0ce0699; // normalRound.sk:7
    T0[182] = 0x16559db4; // normalRound.sk:7
    T0[183] = 0x24b27a61; // normalRound.sk:7
    T0[184] = 0x7077bff0; // normalRound.sk:7
    T0[185] = 0x3e4d8584; // normalRound.sk:7
    T0[186] = 0xc3ef27db; // normalRound.sk:7
    T0[187] = 0xe1f139e7; // normalRound.sk:7
    T0[188] = 0x6b7eb6e2; // normalRound.sk:7
    T0[189] = 0x4a61a9dc; // normalRound.sk:7
    T0[190] = 0x2db57d6f; // normalRound.sk:7
    T0[191] = 0xdc13db38; // normalRound.sk:7
    T0[192] = 0x11a16947; // normalRound.sk:7
    T0[193] = 0x4c63abd8; // normalRound.sk:7
    T0[194] = 0xab3ef662; // normalRound.sk:7
    T0[195] = 0xb635fd74; // normalRound.sk:7
    T0[196] = 0xe007cf10; // normalRound.sk:7
    T0[197] = 0x35bd757f; // normalRound.sk:7
    T0[198] = 0x3af675b; // normalRound.sk:7
    T0[199] = 0x95dd15bf; // normalRound.sk:7
    T0[200] = 0xe7f33be3; // normalRound.sk:7
    T0[201] = 0xb8c60e89; // normalRound.sk:7
    T0[202] = 0x586fa7c0; // normalRound.sk:7
    T0[203] = 0xe504cc16; // normalRound.sk:7
    T0[204] = 0x195098be; // normalRound.sk:7
    T0[205] = 0x18a66e49; // normalRound.sk:7
    T0[206] = 0x42905825; // normalRound.sk:7
    T0[207] = 0x41915927; // normalRound.sk:7
    T0[208] = 0x546ba3c8; // normalRound.sk:7
    T0[209] = 0x8625ed54; // normalRound.sk:7
    T0[210] = 0xae6659; // normalRound.sk:7
    T0[211] = 0x6e7db5e4; // normalRound.sk:7
    T0[212] = 0x1c539bb8; // normalRound.sk:7
    T0[213] = 0xc118d02e; // normalRound.sk:7
    T0[214] = 0xc5ed25df; // normalRound.sk:7
    T0[215] = 0xd615dd34; // normalRound.sk:7
    T0[216] = 0x677ab2ea; // normalRound.sk:7
    T0[217] = 0x9b2ee642; // normalRound.sk:7
    T0[218] = 0x3d4c8486; // normalRound.sk:7
    T0[219] = 0x14a26a41; // normalRound.sk:7
    T0[220] = 0x559d553f; // normalRound.sk:7
    T0[221] = 0x9cda12b1; // normalRound.sk:7
    T0[222] = 0xe306ce12; // normalRound.sk:7
    T0[223] = 0x7d854d0f; // normalRound.sk:7
    T0[224] = 0xfcfa32f1; // normalRound.sk:7
    T0[225] = 0xd7e32bc3; // normalRound.sk:7
    T0[226] = 0x77834b03; // normalRound.sk:7
    T0[227] = 0xf70ac20a; // normalRound.sk:7
    T0[228] = 0x7f72bafa; // normalRound.sk:7
    T0[229] = 0xb4c20a81; // normalRound.sk:7
    T0[230] = 0x4d955d2f; // normalRound.sk:7
    T0[231] = 0x638f471b; // normalRound.sk:7
    T0[232] = 0x72804805; // normalRound.sk:7
    T0[233] = 0xe605cd14; // normalRound.sk:7
    T0[234] = 0x569c543d; // normalRound.sk:7
    T0[235] = 0xe4f23ae1; // normalRound.sk:7
    T0[236] = 0x8dd51daf; // normalRound.sk:7
    T0[237] = 0x3b4e8682; // normalRound.sk:7
    T0[238] = 0xbc33fb78; // normalRound.sk:7
    T0[239] = 0xbec40c8d; // normalRound.sk:7
    T0[240] = 0x4b975f2b; // normalRound.sk:7
    T0[241] = 0x3cba7271; // normalRound.sk:7
    T0[242] = 0x44925a21; // normalRound.sk:7
    T0[243] = 0xd316de32; // normalRound.sk:7
    T0[244] = 0x1ea46c4d; // normalRound.sk:7
    T0[245] = 0xf5fd35ff; // normalRound.sk:7
    T0[246] = 0x25991ac; // normalRound.sk:7
    T0[247] = 0x7c73bbf8; // normalRound.sk:7
    T0[248] = 0x75a92aa; // normalRound.sk:7
    T0[249] = 0x74824a01; // normalRound.sk:7
    T0[250] = 0xb336fe72; // normalRound.sk:7
    T0[251] = 0xd514dc36; // normalRound.sk:7
    T0[252] = 0xfab6353; // normalRound.sk:7
    T0[253] = 0x384f8780; // normalRound.sk:7
    T0[254] = 0x12a06845; // normalRound.sk:7
    T0[255] = 0xfe0dc504; // normalRound.sk:7
    unsigned int T1[256]; // normalRound.sk:8
    for (unsigned int __sa46 = 0; (__sa46 < 256); __sa46++) T1[__sa46] = 0; // normalRound.sk:8
    T1[0] = 0x7bf56a9f; // normalRound.sk:8
    T1[1] = 0x64ea54be; // normalRound.sk:8
    T1[2] = 0x6fe142a3; // normalRound.sk:8
    T1[3] = 0x63ed5ab7; // normalRound.sk:8
    T1[4] = 0xea645337; // normalRound.sk:8
    T1[5] = 0x73fd7a87; // normalRound.sk:8
    T1[6] = 0x77f9728b; // normalRound.sk:8
    T1[7] = 0xdd533d6e; // normalRound.sk:8
    T1[8] = 0x28a6cc6a; // normalRound.sk:8
    T1[9] = 0x1997ae39; // normalRound.sk:8
    T1[10] = 0x7ff16293; // normalRound.sk:8
    T1[11] = 0x33bdfa47; // normalRound.sk:8
    T1[12] = 0xe6684b23; // normalRound.sk:8
    T1[13] = 0xcf411958; // normalRound.sk:8
    T1[14] = 0xb33de1dc; // normalRound.sk:8
    T1[15] = 0x6ee040a0; // normalRound.sk:8
    T1[16] = 0xd25c237f; // normalRound.sk:8
    T1[17] = 0x9a14b3a7; // normalRound.sk:8
    T1[18] = 0xd15f257a; // normalRound.sk:8
    T1[19] = 0x65eb56bd; // normalRound.sk:8
    T1[20] = 0xe26c432f; // normalRound.sk:8
    T1[21] = 0x41cf1ed1; // normalRound.sk:8
    T1[22] = 0x5fd122f3; // normalRound.sk:8
    T1[23] = 0xe8665731; // normalRound.sk:8
    T1[24] = 0xb53bedd6; // normalRound.sk:8
    T1[25] = 0xcc421f5d; // normalRound.sk:8
    T1[26] = 0xba34f3c7; // normalRound.sk:8
    T1[27] = 0xb739e9d0; // normalRound.sk:8
    T1[28] = 0x840a8f85; // normalRound.sk:8
    T1[29] = 0xbc32ffcd; // normalRound.sk:8
    T1[30] = 0x6ae448ac; // normalRound.sk:8
    T1[31] = 0xd8563761; // normalRound.sk:8
    T1[32] = 0xaf21d9f8; // normalRound.sk:8
    T1[33] = 0xe56b4d26; // normalRound.sk:8
    T1[34] = 0x8b059194; // normalRound.sk:8
    T1[35] = 0x3eb0e050; // normalRound.sk:8
    T1[36] = 0x2ea0c060; // normalRound.sk:8
    T1[37] = 0x27a9d27b; // normalRound.sk:8
    T1[38] = 0xef615938; // normalRound.sk:8
    T1[39] = 0xd45a2f75; // normalRound.sk:8
    T1[40] = 0x2ca2c466; // normalRound.sk:8
    T1[41] = 0xbd33fdce; // normalRound.sk:8
    T1[42] = 0xfd737d0e; // normalRound.sk:8
    T1[43] = 0xe9675532; // normalRound.sk:8
    T1[44] = 0x69e74ea9; // normalRound.sk:8
    T1[45] = 0xc04e0749; // normalRound.sk:8
    T1[46] = 0x29a7ce69; // normalRound.sk:8
    T1[47] = 0xd838605; // normalRound.sk:8
    T1[48] = 0x1c92a436; // normalRound.sk:8
    T1[49] = 0xdf513968; // normalRound.sk:8
    T1[50] = 0x3bb5ea5f; // normalRound.sk:8
    T1[51] = 0xdb553164; // normalRound.sk:8
    T1[52] = 0x8e9c12; // normalRound.sk:8
    T1[53] = 0x8e009b9b; // normalRound.sk:8
    T1[54] = 0x1d93a635; // normalRound.sk:8
    T1[55] = 0x820c838f; // normalRound.sk:8
    T1[56] = 0x1f91a233; // normalRound.sk:8
    T1[57] = 0xa84880c; // normalRound.sk:8
    T1[58] = 0x9816b7a1; // normalRound.sk:8
    T1[59] = 0xfa747307; // normalRound.sk:8
    T1[60] = 0xf37d611c; // normalRound.sk:8
    T1[61] = 0x3fb1e253; // normalRound.sk:8
    T1[62] = 0xaa24d3f7; // normalRound.sk:8
    T1[63] = 0x6de346a5; // normalRound.sk:8
    T1[64] = 0x119fbe21; // normalRound.sk:8
    T1[65] = 0x9b15b1a4; // normalRound.sk:8
    T1[66] = 0x34baf44e; // normalRound.sk:8
    T1[67] = 0x28c9814; // normalRound.sk:8
    T1[68] = 0x38d9a17; // normalRound.sk:8
    T1[69] = 0x76f87088; // normalRound.sk:8
    T1[70] = 0x42cc18d4; // normalRound.sk:8
    T1[71] = 0xb836f7c1; // normalRound.sk:8
    T1[72] = 0x4ac408cc; // normalRound.sk:8
    T1[73] = 0x23adda77; // normalRound.sk:8
    T1[74] = 0xce401b5b; // normalRound.sk:8
    T1[75] = 0xab25d1f4; // normalRound.sk:8
    T1[76] = 0x31bffe41; // normalRound.sk:8
    T1[77] = 0xfb757104; // normalRound.sk:8
    T1[78] = 0x37b9f24b; // normalRound.sk:8
    T1[79] = 0x9c12bfad; // normalRound.sk:8
    T1[80] = 0x4bc50acf; // normalRound.sk:8
    T1[81] = 0xc9471552; // normalRound.sk:8
    T1[82] = 0x1896ac3a; // normalRound.sk:8
    T1[83] = 0xf57b6d16; // normalRound.sk:8
    T1[84] = 0x38b6ec5a; // normalRound.sk:8
    T1[85] = 0xe46a4f25; // normalRound.sk:8
    T1[86] = 0xa927d5f2; // normalRound.sk:8
    T1[87] = 0x43cd1ad7; // normalRound.sk:8
    T1[88] = 0x72fc7884; // normalRound.sk:8
    T1[89] = 0xd35d217c; // normalRound.sk:8
    T1[90] = 0xa628cbe3; // normalRound.sk:8
    T1[91] = 0x21afde71; // normalRound.sk:8
    T1[92] = 0x52dc38e4; // normalRound.sk:8
    T1[93] = 0x54da34ee; // normalRound.sk:8
    T1[94] = 0x40ce1cd2; // normalRound.sk:8
    T1[95] = 0xd7592970; // normalRound.sk:8
    T1[96] = 0xc8461751; // normalRound.sk:8
    T1[97] = 0xf7796910; // normalRound.sk:8
    T1[98] = 0xb23ce3df; // normalRound.sk:8
    T1[99] = 0xe36d412c; // normalRound.sk:8
    T1[100] = 0x5bd52aff; // normalRound.sk:8
    T1[101] = 0x55db36ed; // normalRound.sk:8
    T1[102] = 0x2ba5ca6f; // normalRound.sk:8
    T1[103] = 0x9d13bdae; // normalRound.sk:8
    T1[104] = 0x5dd326f5; // normalRound.sk:8
    T1[105] = 0xe16f452a; // normalRound.sk:8
    T1[106] = 0x1a94a83c; // normalRound.sk:8
    T1[107] = 0x67e952bb; // normalRound.sk:8
    T1[108] = 0x48c60cca; // normalRound.sk:8
    T1[109] = 0x24aad47e; // normalRound.sk:8
    T1[110] = 0x87098980; // normalRound.sk:8
    T1[111] = 0xb03ee7d9; // normalRound.sk:8
    T1[112] = 0x49c70ec9; // normalRound.sk:8
    T1[113] = 0xbb35f1c4; // normalRound.sk:8
    T1[114] = 0x58d62cfa; // normalRound.sk:8
    T1[115] = 0x9719a9b0; // normalRound.sk:8
    T1[116] = 0x8a049397; // normalRound.sk:8
    T1[117] = 0x850b8d86; // normalRound.sk:8
    T1[118] = 0x20aedc72; // normalRound.sk:8
    T1[119] = 0xed635d3e; // normalRound.sk:8
    T1[120] = 0xa42acfe5; // normalRound.sk:8
    T1[121] = 0xae20dbfb; // normalRound.sk:8
    T1[122] = 0xc24c034f; // normalRound.sk:8
    T1[123] = 0x39b7ee59; // normalRound.sk:8
    T1[124] = 0x8868c0a; // normalRound.sk:8
    T1[125] = 0xe7694920; // normalRound.sk:8
    T1[126] = 0xeb655134; // normalRound.sk:8
    T1[127] = 0xca441357; // normalRound.sk:8
    T1[128] = 0xd55b2d76; // normalRound.sk:8
    T1[129] = 0x149ab42e; // normalRound.sk:8
    T1[130] = 0xb858a0f; // normalRound.sk:8
    T1[131] = 0xf47a6f15; // normalRound.sk:8
    T1[132] = 0x47c912db; // normalRound.sk:8
    T1[133] = 0x8f019998; // normalRound.sk:8
    T1[134] = 0x5cd224f6; // normalRound.sk:8
    T1[135] = 0xf818203; // normalRound.sk:8
    T1[136] = 0xdc523f6d; // normalRound.sk:8
    T1[137] = 0xbf31f9c8; // normalRound.sk:8
    T1[138] = 0x66e850b8; // normalRound.sk:8
    T1[139] = 0x25abd67d; // normalRound.sk:8
    T1[140] = 0x7cf26496; // normalRound.sk:8
    T1[141] = 0x45cb16dd; // normalRound.sk:8
    T1[142] = 0x18f9e11; // normalRound.sk:8
    T1[143] = 0x6be54aaf; // normalRound.sk:8
    T1[144] = 0x78f66c9a; // normalRound.sk:8
    T1[145] = 0x9917b5a2; // normalRound.sk:8
    T1[146] = 0x57d932eb; // normalRound.sk:8
    T1[147] = 0xc44a0f45; // normalRound.sk:8
    T1[148] = 0x3ab4e85c; // normalRound.sk:8
    T1[149] = 0x32bcf844; // normalRound.sk:8
    T1[150] = 0x88069791; // normalRound.sk:8
    T1[151] = 0x901ea7b9; // normalRound.sk:8
    T1[152] = 0x5ed020f0; // normalRound.sk:8
    T1[153] = 0xf6786b13; // normalRound.sk:8
    T1[154] = 0xa02ec7e9; // normalRound.sk:8
    T1[155] = 0xc828406; // normalRound.sk:8
    T1[156] = 0xc6480b43; // normalRound.sk:8
    T1[157] = 0x46c810d8; // normalRound.sk:8
    T1[158] = 0x139dba27; // normalRound.sk:8
    T1[159] = 0xc34d014c; // normalRound.sk:8
    T1[160] = 0xf8767701; // normalRound.sk:8
    T1[161] = 0x2aa4c86c; // normalRound.sk:8
    T1[162] = 0x22acd874; // normalRound.sk:8
    T1[163] = 0x129cb824; // normalRound.sk:8
    T1[164] = 0x51df3ee1; // normalRound.sk:8
    T1[165] = 0x1e90a030; // normalRound.sk:8
    T1[166] = 0x3cb2e456; // normalRound.sk:8
    T1[167] = 0x44ca14de; // normalRound.sk:8
    T1[168] = 0xda543367; // normalRound.sk:8
    T1[169] = 0xcb451154; // normalRound.sk:8
    T1[170] = 0xb43aefd5; // normalRound.sk:8
    T1[171] = 0x7af4689c; // normalRound.sk:8
    T1[172] = 0x89079592; // normalRound.sk:8
    T1[173] = 0x8d039d9e; // normalRound.sk:8
    T1[174] = 0xfc727f0d; // normalRound.sk:8
    T1[175] = 0x61ef5eb1; // normalRound.sk:8
    T1[176] = 0xff717908; // normalRound.sk:8
    T1[177] = 0xd05e2779; // normalRound.sk:8
    T1[178] = 0x2fa1c263; // normalRound.sk:8
    T1[179] = 0x75fb768d; // normalRound.sk:8
    T1[180] = 0x951badb6; // normalRound.sk:8
    T1[181] = 0xcd431d5e; // normalRound.sk:8
    T1[182] = 0x56d830e8; // normalRound.sk:8
    T1[183] = 0xb13fe5da; // normalRound.sk:8
    T1[184] = 0x74fa748e; // normalRound.sk:8
    T1[185] = 0x4ec000c0; // normalRound.sk:8
    T1[186] = 0xec625f3d; // normalRound.sk:8
    T1[187] = 0xf27c631f; // normalRound.sk:8
    T1[188] = 0x7df36695; // normalRound.sk:8
    T1[189] = 0x62ec58b4; // normalRound.sk:8
    T1[190] = 0xb638ebd3; // normalRound.sk:8
    T1[191] = 0x109ebc22; // normalRound.sk:8
    T1[192] = 0xa22cc3ef; // normalRound.sk:8
    T1[193] = 0x60ee5cb2; // normalRound.sk:8
    T1[194] = 0x3db3e655; // normalRound.sk:8
    T1[195] = 0x36b8f048; // normalRound.sk:8
    T1[196] = 0x48a941e; // normalRound.sk:8
    T1[197] = 0xbe30fbcb; // normalRound.sk:8
    T1[198] = 0xac22dffd; // normalRound.sk:8
    T1[199] = 0xde503b6b; // normalRound.sk:8
    T1[200] = 0xf07e6719; // normalRound.sk:8
    T1[201] = 0xc54b0d46; // normalRound.sk:8
    T1[202] = 0x6ce244a6; // normalRound.sk:8
    T1[203] = 0x789921b; // normalRound.sk:8
    T1[204] = 0x53dd3ae7; // normalRound.sk:8
    T1[205] = 0xa52bcde6; // normalRound.sk:8
    T1[206] = 0x931da1bc; // normalRound.sk:8
    T1[207] = 0x921ca3bf; // normalRound.sk:8
    T1[208] = 0x68e64caa; // normalRound.sk:8
    T1[209] = 0x26a8d078; // normalRound.sk:8
    T1[210] = 0xad23ddfe; // normalRound.sk:8
    T1[211] = 0x7ef06090; // normalRound.sk:8
    T1[212] = 0x50de3ce2; // normalRound.sk:8
    T1[213] = 0x1b95aa3f; // normalRound.sk:8
    T1[214] = 0xee605b3b; // normalRound.sk:8
    T1[215] = 0x1698b028; // normalRound.sk:8
    T1[216] = 0x79f76e99; // normalRound.sk:8
    T1[217] = 0x2da3c665; // normalRound.sk:8
    T1[218] = 0x4fc102c3; // normalRound.sk:8
    T1[219] = 0xa12fc5ea; // normalRound.sk:8
    T1[220] = 0x9e10bbab; // normalRound.sk:8
    T1[221] = 0xd9573562; // normalRound.sk:8
    T1[222] = 0x58b961d; // normalRound.sk:8
    T1[223] = 0x86088b83; // normalRound.sk:8
    T1[224] = 0xf9777502; // normalRound.sk:8
    T1[225] = 0xe06e4729; // normalRound.sk:8
    T1[226] = 0x800e8789; // normalRound.sk:8
    T1[227] = 0x9878e09; // normalRound.sk:8
    T1[228] = 0x71ff7e81; // normalRound.sk:8
    T1[229] = 0xc14f054a; // normalRound.sk:8
    T1[230] = 0x9618abb3; // normalRound.sk:8
    T1[231] = 0x8c029f9d; // normalRound.sk:8
    T1[232] = 0x830d818c; // normalRound.sk:8
    T1[233] = 0x6889018; // normalRound.sk:8
    T1[234] = 0x9f11b9a8; // normalRound.sk:8
    T1[235] = 0xf17f651a; // normalRound.sk:8
    T1[236] = 0xd6582b73; // normalRound.sk:8
    T1[237] = 0x4dc306c5; // normalRound.sk:8
    T1[238] = 0x30befc42; // normalRound.sk:8
    T1[239] = 0xc7490940; // normalRound.sk:8
    T1[240] = 0x941aafb5; // normalRound.sk:8
    T1[241] = 0xb937f5c2; // normalRound.sk:8
    T1[242] = 0x911fa5ba; // normalRound.sk:8
    T1[243] = 0x159bb62d; // normalRound.sk:8
    T1[244] = 0xa729c9e0; // normalRound.sk:8
    T1[245] = 0xfe707b0b; // normalRound.sk:8
    T1[246] = 0x5ad428fc; // normalRound.sk:8
    T1[247] = 0x70fe7c82; // normalRound.sk:8
    T1[248] = 0x59d72ef9; // normalRound.sk:8
    T1[249] = 0x810f858a; // normalRound.sk:8
    T1[250] = 0x35bbf64d; // normalRound.sk:8
    T1[251] = 0x1799b22b; // normalRound.sk:8
    T1[252] = 0xa826d7f1; // normalRound.sk:8
    T1[253] = 0x4cc204c6; // normalRound.sk:8
    T1[254] = 0xa32dc1ec; // normalRound.sk:8
    T1[255] = 0xe808000; // normalRound.sk:8
    unsigned int T2[256]; // normalRound.sk:9
    for (unsigned int __sa47 = 0; (__sa47 < 256); __sa47++) T2[__sa47] = 0; // normalRound.sk:9
    T2[0] = 0x58563b9; // normalRound.sk:9
    T2[1] = 0x1abb42a6; // normalRound.sk:9
    T2[2] = 0x11ad5fad; // normalRound.sk:9
    T2[3] = 0x1db54ba1; // normalRound.sk:9
    T2[4] = 0x94bccb28; // normalRound.sk:9
    T2[5] = 0xd957bb1; // normalRound.sk:9
    T2[6] = 0x99d77b5; // normalRound.sk:9
    T2[7] = 0xa3d2921f; // normalRound.sk:9
    T2[8] = 0x562396ea; // normalRound.sk:9
    T2[9] = 0x6741c5db; // normalRound.sk:9
    T2[10] = 0x18d6fbd; // normalRound.sk:9
    T2[11] = 0x4d15bbf1; // normalRound.sk:9
    T2[12] = 0x98a4df24; // normalRound.sk:9
    T2[13] = 0xb1f6a40d; // normalRound.sk:9
    T2[14] = 0xcd0e2071; // normalRound.sk:9
    T2[15] = 0x10af5cac; // normalRound.sk:9
    T2[16] = 0xaccc8310; // normalRound.sk:9
    T2[17] = 0xe45c5b58; // normalRound.sk:9
    T2[18] = 0xafca8613; // normalRound.sk:9
    T2[19] = 0x1bb941a7; // normalRound.sk:9
    T2[20] = 0x9cacd320; // normalRound.sk:9
    T2[21] = 0x3ff12d83; // normalRound.sk:9
    T2[22] = 0x21cd0f9d; // normalRound.sk:9
    T2[23] = 0x96b8cd2a; // normalRound.sk:9
    T2[24] = 0xcb022a77; // normalRound.sk:9
    T2[25] = 0xb2f0a10e; // normalRound.sk:9
    T2[26] = 0xc41c3b78; // normalRound.sk:9
    T2[27] = 0xc9062c75; // normalRound.sk:9
    T2[28] = 0xfa607946; // normalRound.sk:9
    T2[29] = 0xc210317e; // normalRound.sk:9
    T2[30] = 0x14a750a8; // normalRound.sk:9
    T2[31] = 0xa6d89d1a; // normalRound.sk:9
    T2[32] = 0xd136046d; // normalRound.sk:9
    T2[33] = 0x9ba2da27; // normalRound.sk:9
    T2[34] = 0xf57e6849; // normalRound.sk:9
    T2[35] = 0x400facfc; // normalRound.sk:9
    T2[36] = 0x502f9cec; // normalRound.sk:9
    T2[37] = 0x593d87e5; // normalRound.sk:9
    T2[38] = 0x91b6c42d; // normalRound.sk:9
    T2[39] = 0xaac08916; // normalRound.sk:9
    T2[40] = 0x522b9aee; // normalRound.sk:9
    T2[41] = 0xc312327f; // normalRound.sk:9
    T2[42] = 0x8392f23f; // normalRound.sk:9
    T2[43] = 0x97bace2b; // normalRound.sk:9
    T2[44] = 0x17a155ab; // normalRound.sk:9
    T2[45] = 0xbee8b502; // normalRound.sk:9
    T2[46] = 0x572195eb; // normalRound.sk:9
    T2[47] = 0x7369f9cf; // normalRound.sk:9
    T2[48] = 0x624bcade; // normalRound.sk:9
    T2[49] = 0xa1d6941d; // normalRound.sk:9
    T2[50] = 0x4505a3f9; // normalRound.sk:9
    T2[51] = 0xa5de9819; // normalRound.sk:9
    T2[52] = 0x7e73eec2; // normalRound.sk:9
    T2[53] = 0xf074674c; // normalRound.sk:9
    T2[54] = 0x6349c9df; // normalRound.sk:9
    T2[55] = 0xfc6c7340; // normalRound.sk:9
    T2[56] = 0x614dcfdd; // normalRound.sk:9
    T2[57] = 0x7467f0c8; // normalRound.sk:9
    T2[58] = 0xe6585d5a; // normalRound.sk:9
    T2[59] = 0x849cfb38; // normalRound.sk:9
    T2[60] = 0x8d8ee031; // normalRound.sk:9
    T2[61] = 0x410daffd; // normalRound.sk:9
    T2[62] = 0xd43c0b68; // normalRound.sk:9
    T2[63] = 0x13a959af; // normalRound.sk:9
    T2[64] = 0x6f51ddd3; // normalRound.sk:9
    T2[65] = 0xe55e5859; // normalRound.sk:9
    T2[66] = 0x4a1bb2f6; // normalRound.sk:9
    T2[67] = 0x7c77e8c0; // normalRound.sk:9
    T2[68] = 0x7d75ebc1; // normalRound.sk:9
    T2[69] = 0x89f74b4; // normalRound.sk:9
    T2[70] = 0x3cf72880; // normalRound.sk:9
    T2[71] = 0xc6183d7a; // normalRound.sk:9
    T2[72] = 0x34e73088; // normalRound.sk:9
    T2[73] = 0x5d358be1; // normalRound.sk:9
    T2[74] = 0xb0f4a70c; // normalRound.sk:9
    T2[75] = 0xd53e0869; // normalRound.sk:9
    T2[76] = 0x4f11bdf3; // normalRound.sk:9
    T2[77] = 0x859ef839; // normalRound.sk:9
    T2[78] = 0x491db7f5; // normalRound.sk:9
    T2[79] = 0xe250515e; // normalRound.sk:9
    T2[80] = 0x35e53389; // normalRound.sk:9
    T2[81] = 0xb7faae0b; // normalRound.sk:9
    T2[82] = 0x6643c6da; // normalRound.sk:9
    T2[83] = 0x8b82ea37; // normalRound.sk:9
    T2[84] = 0x4603a6fa; // normalRound.sk:9
    T2[85] = 0x9aa0d926; // normalRound.sk:9
    T2[86] = 0xd73a0e6b; // normalRound.sk:9
    T2[87] = 0x3df52b81; // normalRound.sk:9
    T2[88] = 0xc9778b0; // normalRound.sk:9
    T2[89] = 0xadce8011; // normalRound.sk:9
    T2[90] = 0xd8241f64; // normalRound.sk:9
    T2[91] = 0x5f318de3; // normalRound.sk:9
    T2[92] = 0x2cd71890; // normalRound.sk:9
    T2[93] = 0x2adb1296; // normalRound.sk:9
    T2[94] = 0x3ef32e82; // normalRound.sk:9
    T2[95] = 0xa9c68c15; // normalRound.sk:9
    T2[96] = 0xb6f8ad0a; // normalRound.sk:9
    T2[97] = 0x8986ec35; // normalRound.sk:9
    T2[98] = 0xcc0c2370; // normalRound.sk:9
    T2[99] = 0x9daed021; // normalRound.sk:9
    T2[100] = 0x25c50399; // normalRound.sk:9
    T2[101] = 0x2bd91197; // normalRound.sk:9
    T2[102] = 0x552593e9; // normalRound.sk:9
    T2[103] = 0xe352525f; // normalRound.sk:9
    T2[104] = 0x23c9099f; // normalRound.sk:9
    T2[105] = 0x9faad623; // normalRound.sk:9
    T2[106] = 0x6447c0d8; // normalRound.sk:9
    T2[107] = 0x19bd47a5; // normalRound.sk:9
    T2[108] = 0x36e3368a; // normalRound.sk:9
    T2[109] = 0x5a3b82e6; // normalRound.sk:9
    T2[110] = 0xf9667c45; // normalRound.sk:9
    T2[111] = 0xce082572; // normalRound.sk:9
    T2[112] = 0x37e1358b; // normalRound.sk:9
    T2[113] = 0xc51e3879; // normalRound.sk:9
    T2[114] = 0x26c3069a; // normalRound.sk:9
    T2[115] = 0xe9464c55; // normalRound.sk:9
    T2[116] = 0xf47c6b48; // normalRound.sk:9
    T2[117] = 0xfb627a47; // normalRound.sk:9
    T2[118] = 0x5e338ee2; // normalRound.sk:9
    T2[119] = 0x93b2c22f; // normalRound.sk:9
    T2[120] = 0xda201966; // normalRound.sk:9
    T2[121] = 0xd034076c; // normalRound.sk:9
    T2[122] = 0xbcecb300; // normalRound.sk:9
    T2[123] = 0x4701a5fb; // normalRound.sk:9
    T2[124] = 0x7663f6ca; // normalRound.sk:9
    T2[125] = 0x99a6dc25; // normalRound.sk:9
    T2[126] = 0x95bec829; // normalRound.sk:9
    T2[127] = 0xb4fcab08; // normalRound.sk:9
    T2[128] = 0xabc28a17; // normalRound.sk:9
    T2[129] = 0x6a5bd2d6; // normalRound.sk:9
    T2[130] = 0x7565f3c9; // normalRound.sk:9
    T2[131] = 0x8a80e936; // normalRound.sk:9
    T2[132] = 0x39fd2785; // normalRound.sk:9
    T2[133] = 0xf176644d; // normalRound.sk:9
    T2[134] = 0x22cb0a9e; // normalRound.sk:9
    T2[135] = 0x716dffcd; // normalRound.sk:9
    T2[136] = 0xa2d0911e; // normalRound.sk:9
    T2[137] = 0xc116347d; // normalRound.sk:9
    T2[138] = 0x18bf44a4; // normalRound.sk:9
    T2[139] = 0x5b3981e7; // normalRound.sk:9
    T2[140] = 0x28b6abe; // normalRound.sk:9
    T2[141] = 0x3bf92187; // normalRound.sk:9
    T2[142] = 0x7f71edc3; // normalRound.sk:9
    T2[143] = 0x15a553a9; // normalRound.sk:9
    T2[144] = 0x68366ba; // normalRound.sk:9
    T2[145] = 0xe75a5e5b; // normalRound.sk:9
    T2[146] = 0x29dd1795; // normalRound.sk:9
    T2[147] = 0xbae0b906; // normalRound.sk:9
    T2[148] = 0x4407a0f8; // normalRound.sk:9
    T2[149] = 0x4c17b8f0; // normalRound.sk:9
    T2[150] = 0xf6786d4a; // normalRound.sk:9
    T2[151] = 0xee484552; // normalRound.sk:9
    T2[152] = 0x20cf0c9c; // normalRound.sk:9
    T2[153] = 0x8884ef34; // normalRound.sk:9
    T2[154] = 0xde281562; // normalRound.sk:9
    T2[155] = 0x726bface; // normalRound.sk:9
    T2[156] = 0xb8e4bf04; // normalRound.sk:9
    T2[157] = 0x38ff2484; // normalRound.sk:9
    T2[158] = 0x6d55dbd1; // normalRound.sk:9
    T2[159] = 0xbdeeb001; // normalRound.sk:9
    T2[160] = 0x8698fd3a; // normalRound.sk:9
    T2[161] = 0x542790e8; // normalRound.sk:9
    T2[162] = 0x5c3788e0; // normalRound.sk:9
    T2[163] = 0x6c57d8d0; // normalRound.sk:9
    T2[164] = 0x2fd11d93; // normalRound.sk:9
    T2[165] = 0x604fccdc; // normalRound.sk:9
    T2[166] = 0x420baafe; // normalRound.sk:9
    T2[167] = 0x3afb2286; // normalRound.sk:9
    T2[168] = 0xa4dc9b18; // normalRound.sk:9
    T2[169] = 0xb5fea809; // normalRound.sk:9
    T2[170] = 0xca002976; // normalRound.sk:9
    T2[171] = 0x48760b8; // normalRound.sk:9
    T2[172] = 0xf77a6e4b; // normalRound.sk:9
    T2[173] = 0xf372624f; // normalRound.sk:9
    T2[174] = 0x8290f13e; // normalRound.sk:9
    T2[175] = 0x1fb14da3; // normalRound.sk:9
    T2[176] = 0x8196f43d; // normalRound.sk:9
    T2[177] = 0xaec88512; // normalRound.sk:9
    T2[178] = 0x512d9fed; // normalRound.sk:9
    T2[179] = 0xb9971b7; // normalRound.sk:9
    T2[180] = 0xeb424a57; // normalRound.sk:9
    T2[181] = 0xb3f2a20f; // normalRound.sk:9
    T2[182] = 0x28df1494; // normalRound.sk:9
    T2[183] = 0xcf0a2673; // normalRound.sk:9
    T2[184] = 0xa9b72b6; // normalRound.sk:9
    T2[185] = 0x30ef3c8c; // normalRound.sk:9
    T2[186] = 0x92b0c12e; // normalRound.sk:9
    T2[187] = 0x8c8ce330; // normalRound.sk:9
    T2[188] = 0x38969bf; // normalRound.sk:9
    T2[189] = 0x1cb748a0; // normalRound.sk:9
    T2[190] = 0xc8042f74; // normalRound.sk:9
    T2[191] = 0x6e53ded2; // normalRound.sk:9
    T2[192] = 0xdc2c1360; // normalRound.sk:9
    T2[193] = 0x1eb34ea2; // normalRound.sk:9
    T2[194] = 0x4309a9ff; // normalRound.sk:9
    T2[195] = 0x481fb4f4; // normalRound.sk:9
    T2[196] = 0x7a7be2c6; // normalRound.sk:9
    T2[197] = 0xc014377c; // normalRound.sk:9
    T2[198] = 0xd230016e; // normalRound.sk:9
    T2[199] = 0xa0d4971c; // normalRound.sk:9
    T2[200] = 0x8e88e532; // normalRound.sk:9
    T2[201] = 0xbbe2ba07; // normalRound.sk:9
    T2[202] = 0x12ab5aae; // normalRound.sk:9
    T2[203] = 0x797de7c5; // normalRound.sk:9
    T2[204] = 0x2dd51b91; // normalRound.sk:9
    T2[205] = 0xdb221a67; // normalRound.sk:9
    T2[206] = 0xed4e4051; // normalRound.sk:9
    T2[207] = 0xec4c4350; // normalRound.sk:9
    T2[208] = 0x16a356aa; // normalRound.sk:9
    T2[209] = 0x583f84e4; // normalRound.sk:9
    T2[210] = 0xd332026f; // normalRound.sk:9
    T2[211] = 0x8f6cbc; // normalRound.sk:9
    T2[212] = 0x2ed31e92; // normalRound.sk:9
    T2[213] = 0x6545c3d9; // normalRound.sk:9
    T2[214] = 0x90b4c72c; // normalRound.sk:9
    T2[215] = 0x685fd4d4; // normalRound.sk:9
    T2[216] = 0x78165bb; // normalRound.sk:9
    T2[217] = 0x532999ef; // normalRound.sk:9
    T2[218] = 0x31ed3f8d; // normalRound.sk:9
    T2[219] = 0xdf2a1663; // normalRound.sk:9
    T2[220] = 0xe054575c; // normalRound.sk:9
    T2[221] = 0xa7da9e1b; // normalRound.sk:9
    T2[222] = 0x7b79e1c7; // normalRound.sk:9
    T2[223] = 0xf8647f44; // normalRound.sk:9
    T2[224] = 0x879afe3b; // normalRound.sk:9
    T2[225] = 0x9ea8d522; // normalRound.sk:9
    T2[226] = 0xfe687542; // normalRound.sk:9
    T2[227] = 0x7761f5cb; // normalRound.sk:9
    T2[228] = 0xf917db3; // normalRound.sk:9
    T2[229] = 0xbfeab603; // normalRound.sk:9
    T2[230] = 0xe8444f54; // normalRound.sk:9
    T2[231] = 0xf270614e; // normalRound.sk:9
    T2[232] = 0xfd6e7041; // normalRound.sk:9
    T2[233] = 0x787fe4c4; // normalRound.sk:9
    T2[234] = 0xe156545d; // normalRound.sk:9
    T2[235] = 0x8f8ae633; // normalRound.sk:9
    T2[236] = 0xa8c48f14; // normalRound.sk:9
    T2[237] = 0x33e9398f; // normalRound.sk:9
    T2[238] = 0x4e13bef2; // normalRound.sk:9
    T2[239] = 0xb9e6bc05; // normalRound.sk:9
    T2[240] = 0xea404956; // normalRound.sk:9
    T2[241] = 0xc71a3e7b; // normalRound.sk:9
    T2[242] = 0xef4a4653; // normalRound.sk:9
    T2[243] = 0x6b59d1d7; // normalRound.sk:9
    T2[244] = 0xd9261c65; // normalRound.sk:9
    T2[245] = 0x8094f73c; // normalRound.sk:9
    T2[246] = 0x24c70098; // normalRound.sk:9
    T2[247] = 0xe937eb2; // normalRound.sk:9
    T2[248] = 0x27c1059b; // normalRound.sk:9
    T2[249] = 0xff6a7643; // normalRound.sk:9
    T2[250] = 0x4b19b1f7; // normalRound.sk:9
    T2[251] = 0x695dd7d5; // normalRound.sk:9
    T2[252] = 0xd6380d6a; // normalRound.sk:9
    T2[253] = 0x32eb3a8e; // normalRound.sk:9
    T2[254] = 0xdd2e1061; // normalRound.sk:9
    T2[255] = 0x706ffccc; // normalRound.sk:9
    unsigned int T3[256]; // normalRound.sk:10
    for (unsigned int __sa48 = 0; (__sa48 < 256); __sa48++) T3[__sa48] = 0; // normalRound.sk:10
    T3[0] = 0x7c6bdaab; // normalRound.sk:10
    T3[1] = 0x424ac5b4; // normalRound.sk:10
    T3[2] = 0x5457cebf; // normalRound.sk:10
    T3[3] = 0x4c43c2b3; // normalRound.sk:10
    T3[4] = 0x45c34b3a; // normalRound.sk:10
    T3[5] = 0x6c73d2a3; // normalRound.sk:10
    T3[6] = 0x647fd6a7; // normalRound.sk:10
    T3[7] = 0x2b9a7c0d; // normalRound.sk:10
    T3[8] = 0xda9e89f8; // normalRound.sk:10
    T3[9] = 0xb8cdb8c9; // normalRound.sk:10
    T3[10] = 0x7467deaf; // normalRound.sk:10
    T3[11] = 0xecb392e3; // normalRound.sk:10
    T3[12] = 0x5dd74736; // normalRound.sk:10
    T3[13] = 0xfac6e1f; // normalRound.sk:10
    T3[14] = 0xf7281263; // normalRound.sk:10
    T3[15] = 0x5654cfbe; // normalRound.sk:10
    T3[16] = 0x358b7302; // normalRound.sk:10
    T3[17] = 0xa5533b4a; // normalRound.sk:10
    T3[18] = 0x338e7001; // normalRound.sk:10
    T3[19] = 0x4049c4b5; // normalRound.sk:10
    T3[20] = 0x55db4332; // normalRound.sk:10
    T3[21] = 0x825e091; // normalRound.sk:10
    T3[22] = 0x3407fe8f; // normalRound.sk:10
    T3[23] = 0x41c54938; // normalRound.sk:10
    T3[24] = 0xfb221465; // normalRound.sk:10
    T3[25] = 0x9a96d1c; // normalRound.sk:10
    T3[26] = 0xe5331b6a; // normalRound.sk:10
    T3[27] = 0xff241667; // normalRound.sk:10
    T3[28] = 0x99712554; // normalRound.sk:10
    T3[29] = 0xe9391d6c; // normalRound.sk:10
    T3[30] = 0x5e58cbba; // normalRound.sk:10
    T3[31] = 0x21957908; // normalRound.sk:10
    T3[32] = 0xcf0c0e7f; // normalRound.sk:10
    T3[33] = 0x5bd24435; // normalRound.sk:10
    T3[34] = 0x87602a5b; // normalRound.sk:10
    T3[35] = 0xf6a49fee; // normalRound.sk:10
    T3[36] = 0xd6948ffe; // normalRound.sk:10
    T3[37] = 0xc48f86f7; // normalRound.sk:10
    T3[38] = 0x4fcc4e3f; // normalRound.sk:10
    T3[39] = 0x39817504; // normalRound.sk:10
    T3[40] = 0xd2928dfc; // normalRound.sk:10
    T3[41] = 0xeb3a1c6d; // normalRound.sk:10
    T3[42] = 0x6bfa5c2d; // normalRound.sk:10
    T3[43] = 0x43c64839; // normalRound.sk:10
    T3[44] = 0x585dc8b9; // normalRound.sk:10
    T3[45] = 0x11bd6110; // normalRound.sk:10
    T3[46] = 0xd89d88f9; // normalRound.sk:10
    T3[47] = 0x90f1acdd; // normalRound.sk:10
    T3[48] = 0xb2c2bdcc; // normalRound.sk:10
    T3[49] = 0x2f9c7e0f; // normalRound.sk:10
    T3[50] = 0xfcab9aeb; // normalRound.sk:10
    T3[51] = 0x27907a0b; // normalRound.sk:10
    T3[52] = 0x8ae6a1d0; // normalRound.sk:10
    T3[53] = 0x8d6f2f5e; // normalRound.sk:10
    T3[54] = 0xb0c1bccd; // normalRound.sk:10
    T3[55] = 0x957b2352; // normalRound.sk:10
    T3[56] = 0xb4c7becf; // normalRound.sk:10
    T3[57] = 0x9ef8abda; // normalRound.sk:10
    T3[58] = 0xa1553948; // normalRound.sk:10
    T3[59] = 0x65f35b2a; // normalRound.sk:10
    T3[60] = 0x77e85223; // normalRound.sk:10
    T3[61] = 0xf4a79eef; // normalRound.sk:10
    T3[62] = 0xc5030b7a; // normalRound.sk:10
    T3[63] = 0x5051ccbd; // normalRound.sk:10
    T3[64] = 0xa8d5b0c1; // normalRound.sk:10
    T3[65] = 0xa7503a4b; // normalRound.sk:10
    T3[66] = 0xe2ba95e4; // normalRound.sk:10
    T3[67] = 0x8ee0a3d2; // normalRound.sk:10
    T3[68] = 0x8ce3a2d3; // normalRound.sk:10
    T3[69] = 0x667cd7a6; // normalRound.sk:10
    T3[70] = 0xe20e392; // normalRound.sk:10
    T3[71] = 0xe1351968; // normalRound.sk:10
    T3[72] = 0x1e38eb9a; // normalRound.sk:10
    T3[73] = 0xcc8382f3; // normalRound.sk:10
    T3[74] = 0xdaf6f1e; // normalRound.sk:10
    T3[75] = 0xc7000a7b; // normalRound.sk:10
    T3[76] = 0xe8b590e1; // normalRound.sk:10
    T3[77] = 0x67f05a2b; // normalRound.sk:10
    T3[78] = 0xe4bf96e7; // normalRound.sk:10
    T3[79] = 0xa9593d4c; // normalRound.sk:10
    T3[80] = 0x1c3bea9b; // normalRound.sk:10
    T3[81] = 0x3a66819; // normalRound.sk:10
    T3[82] = 0xbaceb9c8; // normalRound.sk:10
    T3[83] = 0x7be25425; // normalRound.sk:10
    T3[84] = 0xfaae99e8; // normalRound.sk:10
    T3[85] = 0x59d14534; // normalRound.sk:10
    T3[86] = 0xc3060879; // normalRound.sk:10
    T3[87] = 0xc23e293; // normalRound.sk:10
    T3[88] = 0x6e70d3a2; // normalRound.sk:10
    T3[89] = 0x37887203; // normalRound.sk:10
    T3[90] = 0xdd170776; // normalRound.sk:10
    T3[91] = 0xc88580f1; // normalRound.sk:10
    T3[92] = 0x2e10f382; // normalRound.sk:10
    T3[93] = 0x221af584; // normalRound.sk:10
    T3[94] = 0xa26e190; // normalRound.sk:10
    T3[95] = 0x3f847607; // normalRound.sk:10
    T3[96] = 0x1a56918; // normalRound.sk:10
    T3[97] = 0x7fe45627; // normalRound.sk:10
    T3[98] = 0xf52b1362; // normalRound.sk:10
    T3[99] = 0x57d84233; // normalRound.sk:10
    T3[100] = 0x3c0bfa8b; // normalRound.sk:10
    T3[101] = 0x2019f485; // normalRound.sk:10
    T3[102] = 0xdc9b8afb; // normalRound.sk:10
    T3[103] = 0xab5a3c4d; // normalRound.sk:10
    T3[104] = 0x3001fc8d; // normalRound.sk:10
    T3[105] = 0x53de4031; // normalRound.sk:10
    T3[106] = 0xbec8bbca; // normalRound.sk:10
    T3[107] = 0x444fc6b7; // normalRound.sk:10
    T3[108] = 0x1a3ee998; // normalRound.sk:10
    T3[109] = 0xc28a85f4; // normalRound.sk:10
    T3[110] = 0x9f742657; // normalRound.sk:10
    T3[111] = 0xf12d1160; // normalRound.sk:10
    T3[112] = 0x183de899; // normalRound.sk:10
    T3[113] = 0xe7301a6b; // normalRound.sk:10
    T3[114] = 0x3a0ef988; // normalRound.sk:10
    T3[115] = 0xbf443647; // normalRound.sk:10
    T3[116] = 0x85632b5a; // normalRound.sk:10
    T3[117] = 0x9b722455; // normalRound.sk:10
    T3[118] = 0xca8681f0; // normalRound.sk:10
    T3[119] = 0x4bca4c3d; // normalRound.sk:10
    T3[120] = 0xd9110574; // normalRound.sk:10
    T3[121] = 0xcd0f0f7e; // normalRound.sk:10
    T3[122] = 0x15bb6312; // normalRound.sk:10
    T3[123] = 0xf8ad98e9; // normalRound.sk:10
    T3[124] = 0x9afea9d8; // normalRound.sk:10
    T3[125] = 0x5fd44637; // normalRound.sk:10
    T3[126] = 0x47c04a3b; // normalRound.sk:10
    T3[127] = 0x5a36b1a; // normalRound.sk:10
    T3[128] = 0x3b827405; // normalRound.sk:10
    T3[129] = 0xa2dab5c4; // normalRound.sk:10
    T3[130] = 0x9cfbaadb; // normalRound.sk:10
    T3[131] = 0x79e15524; // normalRound.sk:10
    T3[132] = 0x42fe697; // normalRound.sk:10
    T3[133] = 0x8f6c2e5f; // normalRound.sk:10
    T3[134] = 0x3202fd8c; // normalRound.sk:10
    T3[135] = 0x94f7aedf; // normalRound.sk:10
    T3[136] = 0x29997d0c; // normalRound.sk:10
    T3[137] = 0xef3c1e6f; // normalRound.sk:10
    T3[138] = 0x464cc7b6; // normalRound.sk:10
    T3[139] = 0xc08984f5; // normalRound.sk:10
    T3[140] = 0x7262ddac; // normalRound.sk:10
    T3[141] = 0x29e495; // normalRound.sk:10
    T3[142] = 0x88e5a0d1; // normalRound.sk:10
    T3[143] = 0x5c5bcabb; // normalRound.sk:10
    T3[144] = 0x7a6ed9a8; // normalRound.sk:10
    T3[145] = 0xa3563849; // normalRound.sk:10
    T3[146] = 0x241ff687; // normalRound.sk:10
    T3[147] = 0x19b16514; // normalRound.sk:10
    T3[148] = 0xfea89bea; // normalRound.sk:10
    T3[149] = 0xeeb093e2; // normalRound.sk:10
    T3[150] = 0x81652958; // normalRound.sk:10
    T3[151] = 0xb14d3140; // normalRound.sk:10
    T3[152] = 0x3604ff8e; // normalRound.sk:10
    T3[153] = 0x7de75726; // normalRound.sk:10
    T3[154] = 0xd11d0170; // normalRound.sk:10
    T3[155] = 0x92f2addc; // normalRound.sk:10
    T3[156] = 0x1db76716; // normalRound.sk:10
    T3[157] = 0x62ce796; // normalRound.sk:10
    T3[158] = 0xacd3b2c3; // normalRound.sk:10
    T3[159] = 0x17b86213; // normalRound.sk:10
    T3[160] = 0x61f55928; // normalRound.sk:10
    T3[161] = 0xde988bfa; // normalRound.sk:10
    T3[162] = 0xce8083f2; // normalRound.sk:10
    T3[163] = 0xaed0b3c2; // normalRound.sk:10
    T3[164] = 0x2815f081; // normalRound.sk:10
    T3[165] = 0xb6c4bfce; // normalRound.sk:10
    T3[166] = 0xf2a29dec; // normalRound.sk:10
    T3[167] = 0x22ae594; // normalRound.sk:10
    T3[168] = 0x25937b0a; // normalRound.sk:10
    T3[169] = 0x7a06a1b; // normalRound.sk:10
    T3[170] = 0xf9211564; // normalRound.sk:10
    T3[171] = 0x7e68dbaa; // normalRound.sk:10
    T3[172] = 0x83662859; // normalRound.sk:10
    T3[173] = 0x8b6a2c5d; // normalRound.sk:10
    T3[174] = 0x69f95d2c; // normalRound.sk:10
    T3[175] = 0x4845c0b1; // normalRound.sk:10
    T3[176] = 0x6ffc5e2f; // normalRound.sk:10
    T3[177] = 0x318d7100; // normalRound.sk:10
    T3[178] = 0xd4978eff; // normalRound.sk:10
    T3[179] = 0x6079d4a5; // normalRound.sk:10
    T3[180] = 0xbb423445; // normalRound.sk:10
    T3[181] = 0xbaa6c1d; // normalRound.sk:10
    T3[182] = 0x261cf786; // normalRound.sk:10
    T3[183] = 0xf32e1061; // normalRound.sk:10
    T3[184] = 0x627ad5a4; // normalRound.sk:10
    T3[185] = 0x1634ef9e; // normalRound.sk:10
    T3[186] = 0x49c94d3c; // normalRound.sk:10
    T3[187] = 0x75eb5322; // normalRound.sk:10
    T3[188] = 0x7061dcad; // normalRound.sk:10
    T3[189] = 0x4e40c3b2; // normalRound.sk:10
    T3[190] = 0xfd271766; // normalRound.sk:10
    T3[191] = 0xaad6b1c0; // normalRound.sk:10
    T3[192] = 0xd51b0372; // normalRound.sk:10
    T3[193] = 0x4a46c1b0; // normalRound.sk:10
    T3[194] = 0xf0a19ced; // normalRound.sk:10
    T3[195] = 0xe6bc97e6; // normalRound.sk:10
    T3[196] = 0x82eaa5d4; // normalRound.sk:10
    T3[197] = 0xed3f1f6e; // normalRound.sk:10
    T3[198] = 0xc9090d7c; // normalRound.sk:10
    T3[199] = 0x2d9f7f0e; // normalRound.sk:10
    T3[200] = 0x71ed5120; // normalRound.sk:10
    T3[201] = 0x1bb26415; // normalRound.sk:10
    T3[202] = 0x5252cdbc; // normalRound.sk:10
    T3[203] = 0x84efa6d7; // normalRound.sk:10
    T3[204] = 0x2c13f283; // normalRound.sk:10
    T3[205] = 0xdb120475; // normalRound.sk:10
    T3[206] = 0xb7483243; // normalRound.sk:10
    T3[207] = 0xb54b3342; // normalRound.sk:10
    T3[208] = 0x5a5ec9b8; // normalRound.sk:10
    T3[209] = 0xc68c87f6; // normalRound.sk:10
    T3[210] = 0xcb0a0c7d; // normalRound.sk:10
    T3[211] = 0x7664dfae; // normalRound.sk:10
    T3[212] = 0x2a16f180; // normalRound.sk:10
    T3[213] = 0xbccbbacb; // normalRound.sk:10
    T3[214] = 0x4dcf4f3e; // normalRound.sk:10
    T3[215] = 0xa6dcb7c6; // normalRound.sk:10
    T3[216] = 0x786dd8a9; // normalRound.sk:10
    T3[217] = 0xd0918cfd; // normalRound.sk:10
    T3[218] = 0x1437ee9f; // normalRound.sk:10
    T3[219] = 0xd31e0071; // normalRound.sk:10
    T3[220] = 0xad5f3f4e; // normalRound.sk:10
    T3[221] = 0x23967809; // normalRound.sk:10
    T3[222] = 0x80e9a4d5; // normalRound.sk:10
    T3[223] = 0x9d772756; // normalRound.sk:10
    T3[224] = 0x63f65829; // normalRound.sk:10
    T3[225] = 0x51dd4130; // normalRound.sk:10
    T3[226] = 0x917d2150; // normalRound.sk:10
    T3[227] = 0x98fda8d9; // normalRound.sk:10
    T3[228] = 0x6875d0a1; // normalRound.sk:10
    T3[229] = 0x13be6011; // normalRound.sk:10
    T3[230] = 0xbd473746; // normalRound.sk:10
    T3[231] = 0x89692d5c; // normalRound.sk:10
    T3[232] = 0x97782253; // normalRound.sk:10
    T3[233] = 0x86eca7d6; // normalRound.sk:10
    T3[234] = 0xaf5c3e4f; // normalRound.sk:10
    T3[235] = 0x73ee5021; // normalRound.sk:10
    T3[236] = 0x3d877706; // normalRound.sk:10
    T3[237] = 0x1031ec9d; // normalRound.sk:10
    T3[238] = 0xeab691e0; // normalRound.sk:10
    T3[239] = 0x1fb46617; // normalRound.sk:10
    T3[240] = 0xb9413544; // normalRound.sk:10
    T3[241] = 0xe3361869; // normalRound.sk:10
    T3[242] = 0xb34e3041; // normalRound.sk:10
    T3[243] = 0xa0d9b4c5; // normalRound.sk:10
    T3[244] = 0xdf140677; // normalRound.sk:10
    T3[245] = 0x6dff5f2e; // normalRound.sk:10
    T3[246] = 0x3e08fb8a; // normalRound.sk:10
    T3[247] = 0x6a76d1a0; // normalRound.sk:10
    T3[248] = 0x380df889; // normalRound.sk:10
    T3[249] = 0x937e2051; // normalRound.sk:10
    T3[250] = 0xe0b994e5; // normalRound.sk:10
    T3[251] = 0xa4dfb6c7; // normalRound.sk:10
    T3[252] = 0xc1050978; // normalRound.sk:10
    T3[253] = 0x1232ed9c; // normalRound.sk:10
    T3[254] = 0xd7180273; // normalRound.sk:10
    T3[255] = 0x96f4afde; // normalRound.sk:10
    unsigned int _frv_0[4]; // normalRound.sk:12
    for (unsigned int __sa49 = 0; (__sa49 < 4); __sa49++) _frv_0[__sa49] = 0; // normalRound.sk:12
    ShiftRows(_in, _frv_0); // normalRound.sk:12
    for (unsigned int __sa50 = 0; (__sa50 < 4); __sa50++) in[__sa50] = _frv_0[__sa50]; // normalRound.sk:12
    unsigned int output[4]; // normalRound.sk:14
    for (unsigned int __sa51 = 0; (__sa51 < 4); __sa51++) output[__sa51] = 0; // normalRound.sk:14
    for (unsigned int i = 0; (i < 4); ++i) { // normalRound.sk:15
      { // normalRound.sk:15
        unsigned char inv0; // normalRound.sk:16
        inv0 = 0; // normalRound.sk:16
        unsigned char inv1; // normalRound.sk:17
        inv1 = 0; // normalRound.sk:17
        unsigned char inv2; // normalRound.sk:18
        inv2 = 0; // normalRound.sk:18
        unsigned char inv3; // normalRound.sk:19
        inv3 = 0; // normalRound.sk:19
        for (unsigned int j = 0; (j < 8); ++j) { // normalRound.sk:20
          { // normalRound.sk:20
            SK_BITASSIGN(inv0, j, ((in[(((i * 32) + j) / 32)] >> (((i * 32) + j) % 32)) & 1)); // normalRound.sk:21
            SK_BITASSIGN(inv1, j, ((in[((((i * 32) + 8) + j) / 32)] >> ((((i * 32) + 8) + j) % 32)) & 1)); // normalRound.sk:22
            SK_BITASSIGN(inv2, j, ((in[((((i * 32) + 16) + j) / 32)] >> ((((i * 32) + 16) + j) % 32)) & 1)); // normalRound.sk:23
            SK_BITASSIGN(inv3, j, ((in[((((i * 32) + 24) + j) / 32)] >> ((((i * 32) + 24) + j) % 32)) & 1)); // normalRound.sk:24
          }; // normalRound.sk:20
        }; // normalRound.sk:20
        unsigned int i0; // normalRound.sk:26
        i0 = ((unsigned int)(inv0)); // normalRound.sk:26
        unsigned int i1; // normalRound.sk:27
        i1 = ((unsigned int)(inv1)); // normalRound.sk:27
        unsigned int i2; // normalRound.sk:28
        i2 = ((unsigned int)(inv2)); // normalRound.sk:28
        unsigned int i3; // normalRound.sk:29
        i3 = ((unsigned int)(inv3)); // normalRound.sk:29
        for (unsigned int j = 0; (j < 32); ++j) { // normalRound.sk:30
          { // normalRound.sk:30
            unsigned char tmp; // normalRound.sk:31
            tmp = (((((T0[(((i0 * 32) + j) / 32)] >> (((i0 * 32) + j) % 32)) & 1) ^ ((T1[(((i1 * 32) + j) / 32)] >> (((i1 * 32) + j) % 32)) & 1)) ^ ((T2[(((i2 * 32) + j) / 32)] >> (((i2 * 32) + j) % 32)) & 1)) ^ ((T3[(((i3 * 32) + j) / 32)] >> (((i3 * 32) + j) % 32)) & 1)); // normalRound.sk:31
            SK_BITASSIGN(output[(((i * 32) + j) / 32)], (((i * 32) + j) % 32), (tmp ^ ((rkey[(((i * 32) + j) / 32)] >> (((i * 32) + j) % 32)) & 1))); // normalRound.sk:32
          }; // normalRound.sk:30
        }; // normalRound.sk:30
      }; // normalRound.sk:15
    }; // normalRound.sk:15
    for (unsigned int __sa52 = 0; (__sa52 < 4); __sa52++) _out_0[__sa52] = output[__sa52]; // normalRound.sk:35
  }; // normalRound.sk:6
}
void normalRound(unsigned int* in, unsigned int* rkey, unsigned int* _out_0) { // normalRound.sk:40
  unsigned int _frv_0[4]; // normalRound.sk:41
  for (unsigned int __sa53 = 0; (__sa53 < 4); __sa53++) _frv_0[__sa53] = 0; // normalRound.sk:41
  ByteSub(in, _frv_0); // normalRound.sk:41
  unsigned int tmp1[4]; // normalRound.sk:41
  for (unsigned int __sa54 = 0; (__sa54 < 4); __sa54++) tmp1[__sa54] = 0; // normalRound.sk:41
  for (unsigned int __sa55 = 0; (__sa55 < 4); __sa55++) tmp1[__sa55] = _frv_0[__sa55]; // normalRound.sk:41
  unsigned int _frv_1[4]; // normalRound.sk:42
  for (unsigned int __sa56 = 0; (__sa56 < 4); __sa56++) _frv_1[__sa56] = 0; // normalRound.sk:42
  ShiftRows(tmp1, _frv_1); // normalRound.sk:42
  unsigned int tmp2[4]; // normalRound.sk:42
  for (unsigned int __sa57 = 0; (__sa57 < 4); __sa57++) tmp2[__sa57] = 0; // normalRound.sk:42
  for (unsigned int __sa58 = 0; (__sa58 < 4); __sa58++) tmp2[__sa58] = _frv_1[__sa58]; // normalRound.sk:42
  unsigned int _frv_2[4]; // normalRound.sk:43
  for (unsigned int __sa59 = 0; (__sa59 < 4); __sa59++) _frv_2[__sa59] = 0; // normalRound.sk:43
  MixColumns(tmp2, _frv_2); // normalRound.sk:43
  unsigned int tmp3[4]; // normalRound.sk:43
  for (unsigned int __sa60 = 0; (__sa60 < 4); __sa60++) tmp3[__sa60] = 0; // normalRound.sk:43
  for (unsigned int __sa61 = 0; (__sa61 < 4); __sa61++) tmp3[__sa61] = _frv_2[__sa61]; // normalRound.sk:43
  for (unsigned int __sa62 = 0; (__sa62 < 4); __sa62++) _out_0[__sa62] = (tmp3[__sa62] ^ rkey[__sa62]); // normalRound.sk:44
}
void ByteSub(unsigned int* in, unsigned int* _out_0) { // normalRound.sk:47
  unsigned int result[4]; // normalRound.sk:48
  for (unsigned int __sa63 = 0; (__sa63 < 4); __sa63++) result[__sa63] = 0; // normalRound.sk:48
  for (unsigned int i = 0; (i < 16); ++i) { // normalRound.sk:49
    { // normalRound.sk:49
      unsigned char word; // normalRound.sk:50
      word = 0; // normalRound.sk:50
      for (unsigned int j = 0; (j < 8); j++) { // normalRound.sk:51
        { // normalRound.sk:51
          SK_BITASSIGN(word, j, ((in[(((i * 8) + j) / 32)] >> (((i * 8) + j) % 32)) & 1)); // normalRound.sk:52
        }; // normalRound.sk:51
      }; // normalRound.sk:51
      unsigned char _frv_0; // normalRound.sk:54
      _frv_0 = 0; // normalRound.sk:54
      ByteSubInd(word, _frv_0); // normalRound.sk:54
      word = _frv_0; // normalRound.sk:54
      for (unsigned int j = 0; (j < 8); j++) { // normalRound.sk:55
        { // normalRound.sk:55
          SK_BITASSIGN(result[(((i * 8) + j) / 32)], (((i * 8) + j) % 32), ((word >> j) & 1)); // normalRound.sk:56
        }; // normalRound.sk:55
      }; // normalRound.sk:55
    }; // normalRound.sk:49
  }; // normalRound.sk:49
  for (unsigned int __sa64 = 0; (__sa64 < 4); __sa64++) _out_0[__sa64] = result[__sa64]; // normalRound.sk:59
}
void ShiftRows(unsigned int* in, unsigned int* _out_0) { // normalRound.sk:62
  unsigned int shift[4] = {0,1,2,3}; // normalRound.sk:63
  unsigned int Sin[4]; // normalRound.sk:64
  for (unsigned int __sa65 = 0; (__sa65 < 4); __sa65++) Sin[__sa65] = 0; // normalRound.sk:64
  unsigned int Sout[4]; // normalRound.sk:65
  for (unsigned int __sa66 = 0; (__sa66 < 4); __sa66++) Sout[__sa66] = 0; // normalRound.sk:65
  unsigned int k; // normalRound.sk:66
  k = 0; // normalRound.sk:66
  for (unsigned int c = 0; (c < 4); ++c) { // normalRound.sk:67
    { // normalRound.sk:67
      for (unsigned int r = 0; (r < 4); ++r) { // normalRound.sk:68
        { // normalRound.sk:68
          for (unsigned int i = 0; (i < 8); ++i) { // normalRound.sk:69
            { // normalRound.sk:69
              SK_BITASSIGN(Sin[((i + (8 * (r + (4 * c)))) / 32)], ((i + (8 * (r + (4 * c)))) % 32), ((in[(k / 32)] >> (k % 32)) & 1)); // normalRound.sk:70
              k = (k + 1); // normalRound.sk:70
            }; // normalRound.sk:69
          }; // normalRound.sk:69
        }; // normalRound.sk:68
      }; // normalRound.sk:68
    }; // normalRound.sk:67
  }; // normalRound.sk:67
  for (unsigned int c = 0; (c < 4); ++c) { // normalRound.sk:74
    { // normalRound.sk:74
      for (unsigned int r = 0; (r < 4); ++r) { // normalRound.sk:75
        { // normalRound.sk:75
          unsigned int newc; // normalRound.sk:76
          newc = ((c + shift[r]) % 4); // normalRound.sk:76
          for (unsigned int i = 0; (i < 8); ++i) { // normalRound.sk:77
            SK_BITASSIGN(Sout[((i + (8 * (r + (4 * c)))) / 32)], ((i + (8 * (r + (4 * c)))) % 32), ((Sin[((i + (8 * (r + (4 * newc)))) / 32)] >> ((i + (8 * (r + (4 * newc)))) % 32)) & 1)); // normalRound.sk:77
          }; // normalRound.sk:77
        }; // normalRound.sk:75
      }; // normalRound.sk:75
    }; // normalRound.sk:74
  }; // normalRound.sk:74
  for (unsigned int __sa67 = 0; (__sa67 < 4); __sa67++) _out_0[__sa67] = Sout[__sa67]; // normalRound.sk:80
}
void intToBit8(unsigned int& v, unsigned char& _out_0) { // normalRound.sk:83
  unsigned char output; // normalRound.sk:84
  output = 0; // normalRound.sk:84
  for (unsigned int i = 0; (i < 8); ++i) { // normalRound.sk:85
    { // normalRound.sk:85
      SK_BITASSIGN(output, i, ((v % 2) > 0)); // normalRound.sk:86
      v = (v / 2); // normalRound.sk:87
    }; // normalRound.sk:85
  }; // normalRound.sk:85
  _out_0 = output; // normalRound.sk:89
}
void ByteSubInd(unsigned char& in, unsigned char& _out_0) { // normalRound.sk:93
  unsigned int SBTable[256] = {99,124,119,123,242,107,111,197,48,1,103,43,254,215,171,118,202,130,201,125,250,89,71,240,173,212,162,175,156,164,114,192,183,253,147,38,54,63,247,204,52,165,229,241,113,216,49,21,4,199,35,195,24,150,5,154,7,18,128,226,235,39,178,117,9,131,44,26,27,110,90,160,82,59,214,179,41,227,47,132,83,209,0,237,32,252,177,91,106,203,190,57,74,76,88,207,208,239,170,251,67,77,51,133,69,249,2,127,80,60,159,168,81,163,64,143,146,157,56,245,188,182,218,33,16,255,243,210,205,12,19,236,95,151,68,23,196,167,126,61,100,93,25,115,96,129,79,220,34,42,144,136,70,238,184,20,222,94,11,219,224,50,58,10,73,6,36,92,194,211,172,98,145,149,228,121,231,200,55,109,141,213,78,169,108,86,244,234,101,122,174,8,186,120,37,46,28,166,180,198,232,221,116,31,75,189,139,138,112,62,181,102,72,3,246,14,97,53,87,185,134,193,29,158,225,248,152,17,105,217,142,148,155,30,135,233,206,85,40,223,140,161,137,13,191,230,66,104,65,153,45,15,176,84,187,22}; // normalRound.sk:94
  unsigned int x; // normalRound.sk:110
  x = SBTable[((unsigned int)(in))]; // normalRound.sk:110
  unsigned char _frv_0; // normalRound.sk:111
  _frv_0 = 0; // normalRound.sk:111
  intToBit8(x, _frv_0); // normalRound.sk:111
  _out_0 = _frv_0; // normalRound.sk:111
}
void GFM01(unsigned char& in, unsigned char& _out_0) { // normalRound.sk:118
  _out_0 = in; // normalRound.sk:119
}
void GFM03(unsigned char& input, unsigned char& _out_0) { // normalRound.sk:122
  unsigned short int in; // normalRound.sk:124
  in = 0x0; // normalRound.sk:124
  for (unsigned int i = 0; (i < 8); ++i) { // normalRound.sk:127
    SK_BITASSIGN(in, (i + 1), ((input >> i) & 1)); // normalRound.sk:127
  }; // normalRound.sk:126
  for (unsigned int i = 0; (i < 8); ++i) { // normalRound.sk:130
    SK_BITASSIGN(in, i, (((in >> i) & 1) ^ ((input >> i) & 1))); // normalRound.sk:130
  }; // normalRound.sk:129
  unsigned short int modpoly; // normalRound.sk:140
  modpoly = 0x11b; // normalRound.sk:140
  if ((((in >> 8) & 1) == 1)) { // normalRound.sk:142
    { // normalRound.sk:142
      for (unsigned int k = 0; (k < 8); ++k) { // normalRound.sk:144
        SK_BITASSIGN(in, k, (((in >> k) & 1) ^ ((modpoly >> k) & 1))); // normalRound.sk:144
      }; // normalRound.sk:143
    }; // normalRound.sk:142
  } // normalRound.sk:142
  unsigned char out; // normalRound.sk:146
  out = 0; // normalRound.sk:146
  for (unsigned int i = 0; (i < 8); ++i) { // normalRound.sk:147
    { // normalRound.sk:147
      SK_BITASSIGN(out, i, ((in >> i) & 1)); // normalRound.sk:148
    }; // normalRound.sk:147
  }; // normalRound.sk:147
  _out_0 = out; // normalRound.sk:150
}
void GFM02(unsigned char& input, unsigned char& _out_0) { // normalRound.sk:153
  unsigned short int in; // normalRound.sk:154
  in = 0x0; // normalRound.sk:154
  for (unsigned int i = 0; (i < 8); ++i) { // normalRound.sk:156
    SK_BITASSIGN(in, (i + 1), ((input >> i) & 1)); // normalRound.sk:156
  }; // normalRound.sk:155
  unsigned short int modpoly; // normalRound.sk:165
  modpoly = 0x11b; // normalRound.sk:165
  for (unsigned int k = 0; (k < 8); ++k) { // normalRound.sk:168
    { // normalRound.sk:168
      if ((((in >> 8) & 1) == 1)) { // normalRound.sk:169
        { // normalRound.sk:169
          SK_BITASSIGN(in, k, (((in >> k) & 1) ^ ((modpoly >> k) & 1))); // normalRound.sk:170
        }; // normalRound.sk:169
      } // normalRound.sk:169
    }; // normalRound.sk:168
  }; // normalRound.sk:168
  unsigned char out; // normalRound.sk:173
  out = 0; // normalRound.sk:173
  for (unsigned int i = 0; (i < 8); ++i) { // normalRound.sk:174
    { // normalRound.sk:174
      SK_BITASSIGN(out, i, ((in >> i) & 1)); // normalRound.sk:175
    }; // normalRound.sk:174
  }; // normalRound.sk:174
  _out_0 = out; // normalRound.sk:177
}
void row1Fil(unsigned int& input, unsigned char& _out_0) { // normalRound.sk:180
  unsigned char in1; // normalRound.sk:181
  in1 = 0; // normalRound.sk:181
  unsigned char in2; // normalRound.sk:182
  in2 = 0; // normalRound.sk:182
  unsigned char in3; // normalRound.sk:183
  in3 = 0; // normalRound.sk:183
  unsigned char in4; // normalRound.sk:184
  in4 = 0; // normalRound.sk:184
  for (unsigned int i = 0; (i < 8); ++i) { // normalRound.sk:185
    { // normalRound.sk:185
      SK_BITASSIGN(in1, i, ((input >> i) & 1)); // normalRound.sk:186
      SK_BITASSIGN(in2, i, ((input >> (i + 8)) & 1)); // normalRound.sk:187
      SK_BITASSIGN(in3, i, ((input >> (i + 16)) & 1)); // normalRound.sk:188
      SK_BITASSIGN(in4, i, ((input >> (i + 24)) & 1)); // normalRound.sk:189
    }; // normalRound.sk:185
  }; // normalRound.sk:185
  unsigned char _frv_0; // normalRound.sk:191
  _frv_0 = 0; // normalRound.sk:191
  GFM02(in1, _frv_0); // normalRound.sk:191
  in1 = _frv_0; // normalRound.sk:191
  unsigned char _frv_1; // normalRound.sk:192
  _frv_1 = 0; // normalRound.sk:192
  GFM03(in2, _frv_1); // normalRound.sk:192
  in2 = _frv_1; // normalRound.sk:192
  unsigned char _frv_2; // normalRound.sk:193
  _frv_2 = 0; // normalRound.sk:193
  GFM01(in3, _frv_2); // normalRound.sk:193
  in3 = _frv_2; // normalRound.sk:193
  unsigned char _frv_3; // normalRound.sk:194
  _frv_3 = 0; // normalRound.sk:194
  GFM01(in4, _frv_3); // normalRound.sk:194
  in4 = _frv_3; // normalRound.sk:194
  _out_0 = (((in1 ^ in2) ^ in3) ^ in4); // normalRound.sk:195
}
void row2Fil(unsigned int& input, unsigned char& _out_0) { // normalRound.sk:198
  unsigned char in1; // normalRound.sk:199
  in1 = 0; // normalRound.sk:199
  unsigned char in2; // normalRound.sk:200
  in2 = 0; // normalRound.sk:200
  unsigned char in3; // normalRound.sk:201
  in3 = 0; // normalRound.sk:201
  unsigned char in4; // normalRound.sk:202
  in4 = 0; // normalRound.sk:202
  for (unsigned int i = 0; (i < 8); ++i) { // normalRound.sk:203
    { // normalRound.sk:203
      SK_BITASSIGN(in1, i, ((input >> i) & 1)); // normalRound.sk:204
      SK_BITASSIGN(in2, i, ((input >> (i + 8)) & 1)); // normalRound.sk:205
      SK_BITASSIGN(in3, i, ((input >> (i + 16)) & 1)); // normalRound.sk:206
      SK_BITASSIGN(in4, i, ((input >> (i + 24)) & 1)); // normalRound.sk:207
    }; // normalRound.sk:203
  }; // normalRound.sk:203
  unsigned char _frv_0; // normalRound.sk:209
  _frv_0 = 0; // normalRound.sk:209
  GFM01(in1, _frv_0); // normalRound.sk:209
  in1 = _frv_0; // normalRound.sk:209
  unsigned char _frv_1; // normalRound.sk:210
  _frv_1 = 0; // normalRound.sk:210
  GFM02(in2, _frv_1); // normalRound.sk:210
  in2 = _frv_1; // normalRound.sk:210
  unsigned char _frv_2; // normalRound.sk:211
  _frv_2 = 0; // normalRound.sk:211
  GFM03(in3, _frv_2); // normalRound.sk:211
  in3 = _frv_2; // normalRound.sk:211
  unsigned char _frv_3; // normalRound.sk:212
  _frv_3 = 0; // normalRound.sk:212
  GFM01(in4, _frv_3); // normalRound.sk:212
  in4 = _frv_3; // normalRound.sk:212
  _out_0 = (((in1 ^ in2) ^ in3) ^ in4); // normalRound.sk:213
}
void row3Fil(unsigned int& input, unsigned char& _out_0) { // normalRound.sk:218
  unsigned char in1; // normalRound.sk:219
  in1 = 0; // normalRound.sk:219
  unsigned char in2; // normalRound.sk:220
  in2 = 0; // normalRound.sk:220
  unsigned char in3; // normalRound.sk:221
  in3 = 0; // normalRound.sk:221
  unsigned char in4; // normalRound.sk:222
  in4 = 0; // normalRound.sk:222
  for (unsigned int i = 0; (i < 8); ++i) { // normalRound.sk:223
    { // normalRound.sk:223
      SK_BITASSIGN(in1, i, ((input >> i) & 1)); // normalRound.sk:224
      SK_BITASSIGN(in2, i, ((input >> (i + 8)) & 1)); // normalRound.sk:225
      SK_BITASSIGN(in3, i, ((input >> (i + 16)) & 1)); // normalRound.sk:226
      SK_BITASSIGN(in4, i, ((input >> (i + 24)) & 1)); // normalRound.sk:227
    }; // normalRound.sk:223
  }; // normalRound.sk:223
  unsigned char _frv_0; // normalRound.sk:229
  _frv_0 = 0; // normalRound.sk:229
  GFM01(in1, _frv_0); // normalRound.sk:229
  in1 = _frv_0; // normalRound.sk:229
  unsigned char _frv_1; // normalRound.sk:230
  _frv_1 = 0; // normalRound.sk:230
  GFM01(in2, _frv_1); // normalRound.sk:230
  in2 = _frv_1; // normalRound.sk:230
  unsigned char _frv_2; // normalRound.sk:231
  _frv_2 = 0; // normalRound.sk:231
  GFM02(in3, _frv_2); // normalRound.sk:231
  in3 = _frv_2; // normalRound.sk:231
  unsigned char _frv_3; // normalRound.sk:232
  _frv_3 = 0; // normalRound.sk:232
  GFM03(in4, _frv_3); // normalRound.sk:232
  in4 = _frv_3; // normalRound.sk:232
  _out_0 = (((in1 ^ in2) ^ in3) ^ in4); // normalRound.sk:233
}
void row4Fil(unsigned int& input, unsigned char& _out_0) { // normalRound.sk:237
  unsigned char in1; // normalRound.sk:238
  in1 = 0; // normalRound.sk:238
  unsigned char in2; // normalRound.sk:239
  in2 = 0; // normalRound.sk:239
  unsigned char in3; // normalRound.sk:240
  in3 = 0; // normalRound.sk:240
  unsigned char in4; // normalRound.sk:241
  in4 = 0; // normalRound.sk:241
  for (unsigned int i = 0; (i < 8); ++i) { // normalRound.sk:242
    { // normalRound.sk:242
      SK_BITASSIGN(in1, i, ((input >> i) & 1)); // normalRound.sk:243
      SK_BITASSIGN(in2, i, ((input >> (i + 8)) & 1)); // normalRound.sk:244
      SK_BITASSIGN(in3, i, ((input >> (i + 16)) & 1)); // normalRound.sk:245
      SK_BITASSIGN(in4, i, ((input >> (i + 24)) & 1)); // normalRound.sk:246
    }; // normalRound.sk:242
  }; // normalRound.sk:242
  unsigned char _frv_0; // normalRound.sk:248
  _frv_0 = 0; // normalRound.sk:248
  GFM03(in1, _frv_0); // normalRound.sk:248
  in1 = _frv_0; // normalRound.sk:248
  unsigned char _frv_1; // normalRound.sk:249
  _frv_1 = 0; // normalRound.sk:249
  GFM01(in2, _frv_1); // normalRound.sk:249
  in2 = _frv_1; // normalRound.sk:249
  unsigned char _frv_2; // normalRound.sk:250
  _frv_2 = 0; // normalRound.sk:250
  GFM01(in3, _frv_2); // normalRound.sk:250
  in3 = _frv_2; // normalRound.sk:250
  unsigned char _frv_3; // normalRound.sk:251
  _frv_3 = 0; // normalRound.sk:251
  GFM02(in4, _frv_3); // normalRound.sk:251
  in4 = _frv_3; // normalRound.sk:251
  _out_0 = (((in1 ^ in2) ^ in3) ^ in4); // normalRound.sk:252
}
void MixColumns(unsigned int* input, unsigned int* _out_0) { // normalRound.sk:255
  unsigned int output[4]; // normalRound.sk:256
  for (unsigned int __sa68 = 0; (__sa68 < 4); __sa68++) output[__sa68] = 0; // normalRound.sk:256
  for (unsigned int i = 0; (i < 4); ++i) { // normalRound.sk:257
    { // normalRound.sk:257
      unsigned int word; // normalRound.sk:258
      word = 0; // normalRound.sk:258
      for (unsigned int j = 0; (j < 32); ++j) { // normalRound.sk:259
        { // normalRound.sk:259
          SK_BITASSIGN(word, j, ((input[(((i * 32) + j) / 32)] >> (((i * 32) + j) % 32)) & 1)); // normalRound.sk:260
        }; // normalRound.sk:259
      }; // normalRound.sk:259
      unsigned int _frv_0; // normalRound.sk:262
      _frv_0 = 0; // normalRound.sk:262
      MixColumnsWord(word, _frv_0); // normalRound.sk:262
      word = _frv_0; // normalRound.sk:262
      for (unsigned int j = 0; (j < 32); ++j) { // normalRound.sk:263
        { // normalRound.sk:263
          SK_BITASSIGN(output[(((i * 32) + j) / 32)], (((i * 32) + j) % 32), ((word >> j) & 1)); // normalRound.sk:264
        }; // normalRound.sk:263
      }; // normalRound.sk:263
    }; // normalRound.sk:257
  }; // normalRound.sk:257
  for (unsigned int __sa69 = 0; (__sa69 < 4); __sa69++) _out_0[__sa69] = output[__sa69]; // normalRound.sk:267
}
void MixColumnsWord(unsigned int& input, unsigned int& _out_0) { // normalRound.sk:270
  unsigned char _frv_0; // normalRound.sk:271
  _frv_0 = 0; // normalRound.sk:271
  row1Fil(input, _frv_0); // normalRound.sk:271
  unsigned char o1; // normalRound.sk:271
  o1 = 0; // normalRound.sk:271
  o1 = _frv_0; // normalRound.sk:271
  unsigned char _frv_1; // normalRound.sk:272
  _frv_1 = 0; // normalRound.sk:272
  row2Fil(input, _frv_1); // normalRound.sk:272
  unsigned char o2; // normalRound.sk:272
  o2 = 0; // normalRound.sk:272
  o2 = _frv_1; // normalRound.sk:272
  unsigned char _frv_2; // normalRound.sk:273
  _frv_2 = 0; // normalRound.sk:273
  row3Fil(input, _frv_2); // normalRound.sk:273
  unsigned char o3; // normalRound.sk:273
  o3 = 0; // normalRound.sk:273
  o3 = _frv_2; // normalRound.sk:273
  unsigned char _frv_3; // normalRound.sk:274
  _frv_3 = 0; // normalRound.sk:274
  row4Fil(input, _frv_3); // normalRound.sk:274
  unsigned char o4; // normalRound.sk:274
  o4 = 0; // normalRound.sk:274
  o4 = _frv_3; // normalRound.sk:274
  unsigned int output; // normalRound.sk:275
  output = 0; // normalRound.sk:275
  for (unsigned int i = 0; (i < 8); ++i) { // normalRound.sk:276
    { // normalRound.sk:276
      SK_BITASSIGN(output, i, ((o1 >> i) & 1)); // normalRound.sk:277
      SK_BITASSIGN(output, (i + 8), ((o2 >> i) & 1)); // normalRound.sk:278
      SK_BITASSIGN(output, (i + 16), ((o3 >> i) & 1)); // normalRound.sk:279
      SK_BITASSIGN(output, (i + 24), ((o4 >> i) & 1)); // normalRound.sk:280
    }; // normalRound.sk:276
  }; // normalRound.sk:276
  _out_0 = output; // normalRound.sk:282
}
